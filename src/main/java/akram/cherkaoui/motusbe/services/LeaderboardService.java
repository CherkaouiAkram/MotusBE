package akram.cherkaoui.motusbe.services;

import akram.cherkaoui.motusbe.dto.LeaderboardEntryDTO;
import akram.cherkaoui.motusbe.entities.Game;
import akram.cherkaoui.motusbe.entities.User;
import akram.cherkaoui.motusbe.enums.Difficulty;
import akram.cherkaoui.motusbe.repositories.GameRepository;
import akram.cherkaoui.motusbe.repositories.WallOfFameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static akram.cherkaoui.motusbe.services.WallOfFameService.isGameWon;

@Service
public class LeaderboardService {

    private final WallOfFameRepository wallOfFameRepository;
    private final GameRepository gameRepository;

    public LeaderboardService(WallOfFameRepository wallOfFameRepository, GameRepository gameRepository) {
        this.wallOfFameRepository = wallOfFameRepository;
        this.gameRepository = gameRepository;
    }

    public List<LeaderboardEntryDTO> getLeaderboardEntries() {
        return wallOfFameRepository.findAll().stream().map(entry -> {
            User user = entry.getUser();
            List<Game> games = gameRepository.findByUser(user);

            LeaderboardEntryDTO dto = new LeaderboardEntryDTO();
            dto.id = user.getId();
            dto.username = user.getPseudo();
            dto.totalGames = games.size();
            dto.wins = (int) games.stream().filter(WallOfFameService::isGameWon).count();
            dto.winRate = dto.totalGames > 0 ? (dto.wins * 100.0 / dto.totalGames) : 0.0;
            dto.averageAttempts = dto.wins > 0
                    ? games.stream().filter(WallOfFameService::isGameWon).mapToInt(Game::getNumberOfAttempts).average().orElse(0.0)
                    : 0.0;
            dto.totalScore = entry.getScore();
            dto.easyWins = (int) games.stream().filter(g -> (isGameWon(g) ) && g.getDifficulty() == Difficulty.EASY).count();
            dto.mediumWins = (int) games.stream().filter(g -> (isGameWon(g) ) && g.getDifficulty() == Difficulty.MEDIUM).count();
            dto.hardWins = (int) games.stream().filter(g -> (isGameWon(g) ) && g.getDifficulty() == Difficulty.HARD).count();

            int bestStreak = 0, currentStreak = 0;


            dto.bestStreak = bestStreak;
            dto.currentStreak = currentStreak;

            return dto;
        }).collect(Collectors.toList());
    }
}
