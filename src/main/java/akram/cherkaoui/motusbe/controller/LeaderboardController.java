package akram.cherkaoui.motusbe.controller;

import akram.cherkaoui.motusbe.dto.LeaderboardEntryDTO;
import akram.cherkaoui.motusbe.entities.User;
import akram.cherkaoui.motusbe.repositories.UserRepository;
import akram.cherkaoui.motusbe.services.JwtService;
import akram.cherkaoui.motusbe.services.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wallofFame")
public class LeaderboardController {


    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LeaderboardService leaderboardService;

    @GetMapping
    public List<LeaderboardEntryDTO> getLeaderboard(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7); // remove "Bearer "

        String email = jwtService.extractEmail(token);

        User user = userRepository.findByEmail(email).get();


        return leaderboardService.getLeaderboardEntries();
    }
}