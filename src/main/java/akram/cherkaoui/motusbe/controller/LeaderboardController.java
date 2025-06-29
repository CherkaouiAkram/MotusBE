package akram.cherkaoui.motusbe.controller;

import akram.cherkaoui.motusbe.dto.LeaderboardEntryDTO;
import akram.cherkaoui.motusbe.entities.User;
import akram.cherkaoui.motusbe.repositories.UserRepository;
import akram.cherkaoui.motusbe.services.JwtService;
import akram.cherkaoui.motusbe.services.LeaderboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallofFame")
public class LeaderboardController {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final LeaderboardService leaderboardService;

    public LeaderboardController(JwtService jwtService,
                                 UserRepository userRepository,
                                 LeaderboardService leaderboardService) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.leaderboardService = leaderboardService;
    }

    @GetMapping
    public List<LeaderboardEntryDTO> getLeaderboard(@RequestHeader("Authorization") String authHeader) {
        User user = getUserFromAuthHeader(authHeader);
        // You can use `user` for access control, logging, or personalized leaderboard if needed.
        return leaderboardService.getLeaderboardEntries();
    }

    private User getUserFromAuthHeader(String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String email = jwtService.extractEmail(token);
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}