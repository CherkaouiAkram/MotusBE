package akram.cherkaoui.motusbe.controller;

import akram.cherkaoui.motusbe.entities.User;
import akram.cherkaoui.motusbe.repositories.UserRepository;
import akram.cherkaoui.motusbe.services.JwtService;
import akram.cherkaoui.motusbe.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class WordController {

    @Autowired
    private WordService wordService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRe

    @GetMapping("/start")
    public String getRandomWord(@RequestParam int length, @RequestHeader("Authorization") String authHeader) {

        String token = authHeader.substring(7); // remove "Bearer "

        String email = jwtService.extractEmail(token);

        User user = userRepository.findByEmail(email).get();

        return wordService.getRandomWordByLength(length);
    }

    @PostMapping("/end")
}