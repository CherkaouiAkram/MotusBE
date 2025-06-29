package akram.cherkaoui.motusbe.controller;

import akram.cherkaoui.motusbe.dto.GameEndRequest;
import akram.cherkaoui.motusbe.dto.GameStartRequest;
import akram.cherkaoui.motusbe.dto.GameStartResponse;
import akram.cherkaoui.motusbe.entities.Game;
import akram.cherkaoui.motusbe.entities.User;
import akram.cherkaoui.motusbe.enums.Difficulty;
import akram.cherkaoui.motusbe.repositories.GameRepository;
import akram.cherkaoui.motusbe.repositories.UserRepository;
import akram.cherkaoui.motusbe.services.JwtService;
import akram.cherkaoui.motusbe.services.WallOfFameService;
import akram.cherkaoui.motusbe.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private WordService wordService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private WallOfFameService wallOfFameService;

    @PostMapping("/start")
    public ResponseEntity<GameStartResponse> startGame(@RequestBody GameStartRequest request, @RequestHeader("Authorization") String authHeader) {

        String token = authHeader.substring(7); // remove "Bearer "

        String email = jwtService.extractEmail(token);

        User user = userRepository.findByEmail(email).get();

        int length = 5;

        length = switch (Difficulty.valueOf(request.getDifficulty().toUpperCase())){
            case EASY -> 4;
            case MEDIUM -> 5;
            case HARD -> 6;
        };

        String theWord = wordService.getRandomWordByLength(length);


        Game newGame = new Game();
        newGame.setDifficulty(Difficulty.valueOf(request.getDifficulty().toUpperCase()));
        newGame.setUser(user);
        Game savedGame = gameRepository.save(newGame);

        GameStartResponse response = new GameStartResponse();
        response.setGameId(savedGame.getId().toString());
        response.setWord(theWord.toUpperCase());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/end")
    public ResponseEntity<?> endGame(@RequestBody GameEndRequest request, @RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);

        String email = jwtService.extractEmail(token);

        User user = userRepository.findByEmail(email).get();

        Game game = gameRepository.findById(UUID.fromString(request.getGameId())).get();

        game.setNumberOfAttempts(Integer.parseInt(request.getNbAttempts()));

        gameRepository.save(game);

        if (WallOfFameService.isGameWon(game)) {
            int oldStrike = user.getCurrentStrike();
            int oldBestStrike = user.getBestStrike();

            user.setCurrentStrike(oldStrike + 1);
            if (!(oldBestStrike > (oldStrike +1))) user.setBestStrike(oldStrike +1);
        } else {
            user.setCurrentStrike(0);
        }

        wallOfFameService.updateUserScore(user);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}