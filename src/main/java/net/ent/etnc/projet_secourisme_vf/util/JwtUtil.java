package net.ent.etnc.projet_secourisme_vf.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    
    private static final String SECRET = "CLE_SECRETE_A_NE_PAS_DIVULGUER_CEST_IMPORTANT_SINON_CEST_MORT_JEN_RAJOUTE_ENCORE_UN_PEU"; // Clé secrète (à sécuriser en production)
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8)); // Génération de la clé

    public String generateToken(UserDetails userDetails) {
        // 1 heure
        int jwtExpirationInMs = 3600000;
        return Jwts.builder()
                .subject(userDetails.getUsername()) // Nouvelle API fluide
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                .signWith(key) // Utilisation de la SecretKey sans SignatureAlgorithm
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(key) // Vérification avec la clé
                .build()
                .parseSignedClaims(token) // Nouvelle méthode pour parser les claims signés
                .getPayload()
                .getSubject();
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser()
                .verifyWith(key) // Vérification avec la clé
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
        return expiration.before(new Date());
    }
}