package akram.cherkaoui.motusbe.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Duration;
import java.util.Date;

@Service
public class JwtService {

    private final String SECRET_KEY = "eW91cl9zZWNyZXRfa2V5X3doaWNoX3Nob3VsZF9iZV9hX2xvbmdfb25lCg=="; // use a secure key, store safely

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token); // Throws exception if invalid
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String generateToken(String email) {
        // Your existing token generation logic
        return Jwts.builder()
                .setSubject(email)
                .signWith(getSigningKey())
                .setExpiration(Date.from(new Date().toInstant().plus(Duration.ofHours(2))))
                .compact();
    }

    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}