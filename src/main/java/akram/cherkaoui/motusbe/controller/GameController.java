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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final WordService wordService;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final WallOfFameService wallOfFameService;

    public GameController(WordService wordService,
                          JwtService jwtService,
                          UserRepository userRepository,
                          GameRepository gameRepository,
                          WallOfFameService wallOfFameService) {
        this.wordService = wordService;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.wallOfFameService = wallOfFameService;
    }

    @PostMapping("/start")
    public ResponseEntity<GameStartResponse> startGame(@RequestBody GameStartRequest request,
                                                       @RequestHeader("Authorization") String authHeader) {
        User user = getUserFromAuthHeader(authHeader);

        Difficulty difficulty = Difficulty.valueOf(request.getDifficulty().toUpperCase());
        int length = getWordLengthByDifficulty(difficulty);

        String theWord = wordService.getRandomWordByLength(length);

        Game newGame = new Game();
        newGame.setDifficulty(difficulty);
        newGame.setUser(user);
        newGame.setNumberOfAttempts(-1);
        Game savedGame = gameRepository.save(newGame);

        GameStartResponse response = new GameStartResponse();
        response.setGameId(savedGame.getId().toString());
        response.setWord(theWord.toUpperCase());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/end")
    public ResponseEntity<?> endGame(@RequestBody GameEndRequest request,
                                     @RequestHeader("Authorization") String authHeader) {
        User user = getUserFromAuthHeader(authHeader);

        UUID gameId = UUID.fromString(request.getGameId());
        Optional<Game> optionalGame = gameRepository.findById(gameId);

        if (optionalGame.isEmpty()) {
            return ResponseEntity.badRequest().body("Game not found");
        }

        Game game = optionalGame.get();
        int attempts = Integer.parseInt(request.getNbAttempts());
        game.setNumberOfAttempts(attempts);
        gameRepository.save(game);

        // Update user's streak
        if (WallOfFameService.isGameWon(game)) {
            int current = user.getCurrentStrike() + 1;
            user.setCurrentStrike(current);
            user.setBestStrike(Math.max(current, user.getBestStrike()));
        } else {
            user.setCurrentStrike(0);
        }

        wallOfFameService.updateUserScore(user);
        userRepository.save(user);

        return ResponseEntity.ok().build();
    }

    private User getUserFromAuthHeader(String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String email = jwtService.extractEmail(token);
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }

    private int getWordLengthByDifficulty(Difficulty difficulty) {
        return switch (difficulty) {
            case EASY -> 4;
            case MEDIUM -> 5;
            case HARD -> 6;
        };
    }
}