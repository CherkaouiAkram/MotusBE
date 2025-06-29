package akram.cherkaoui.motusbe.services;

import akram.cherkaoui.motusbe.entities.Game;
import akram.cherkaoui.motusbe.entities.User;
import akram.cherkaoui.motusbe.entities.WallOfFame;
import akram.cherkaoui.motusbe.repositories.GameRepository;
import akram.cherkaoui.motusbe.repositories.WallOfFameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WallOfFameService {

    private final WallOfFameRepository wallOfFameRepository;
    private final GameRepository gameRepository;

    public WallOfFameService(WallOfFameRepository wallOfFameRepository, GameRepository gameRepository) {
        this.wallOfFameRepository = wallOfFameRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional
    public void updateUserScore(User user) {
        List<Game> userGames = gameRepository.findByUser(user);

        int totalScore = userGames.stream()
                .mapToInt(game -> {
                    int attempts = game.getNumberOfAttempts();
                    return isGameWon(game) ? 100 - (attempts * 10) : 0;
                })
                .sum();
        WallOfFame wallOfFame = wallOfFameRepository.findByUserId(user.getId())
            .orElseGet(() -> {
                WallOfFame newEntry = new WallOfFame();
                newEntry.setUser(user);
                return newEntry;
            });

        wallOfFame.setScore(totalScore);
        wallOfFameRepository.save(wallOfFame);
    }

    public static boolean isGameWon(Game game) {
        if (game.getNumberOfAttempts() == -1) {
            return false;
        }
        return switch (game.getDifficulty()) {
            case EASY -> game.getNumberOfAttempts() < 6;
            case MEDIUM -> game.getNumberOfAttempts() < 5;
            case HARD -> game.getNumberOfAttempts() < 4;
        };
    }
}