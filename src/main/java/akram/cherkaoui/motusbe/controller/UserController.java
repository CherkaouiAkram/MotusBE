package akram.cherkaoui.motusbe.controller;

import akram.cherkaoui.motusbe.dto.UserInfoResponse;
import akram.cherkaoui.motusbe.entities.User;
import akram.cherkaoui.motusbe.repositories.UserRepository;
import akram.cherkaoui.motusbe.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public UserController(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUserInfo(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("Invalid Authorization header");
        }

        String token = authHeader.substring(7); // remove "Bearer "
        if (!jwtService.isTokenValid(token)) {
            return ResponseEntity.status(401).body("Invalid or expired token");
        }

        String email = jwtService.extractEmail(token);

        User user = userRepository.findByEmail(email).get();

        // You can return more info if you have a UserService
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setEmail(user.getEmail());
        userInfoResponse.setPseudo(user.getPseudo());
        return ResponseEntity.ok().body(userInfoResponse);
    }

}