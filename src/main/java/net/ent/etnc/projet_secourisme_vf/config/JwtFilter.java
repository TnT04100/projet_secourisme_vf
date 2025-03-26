package net.ent.etnc.projet_secourisme_vf.config;

import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ent.etnc.projet_secourisme_vf.service.CustomUserDetailsService;
import net.ent.etnc.projet_secourisme_vf.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    @NonNull
    private JwtUtil jwtUtil;

    @NonNull
    private CustomUserDetailsService userDetailsService;

    @NonNull
    private AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        Logger log = LoggerFactory.getLogger(JwtFilter.class);

        String header = request.getHeader("Authorization");
        log.debug("En-tête Authorization reçu : '{}'", header);

        String token = extractToken(header);
        if (token != null) {
            processToken(token, request, log);
        } else {
            log.debug("Aucun token valide trouvé");
        }
        chain.doFilter(request, response);
    }

    private String extractToken(String header) {
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            if (isValidJwtFormat(token)) {
                return token;
            }
        }
        return null;
    }

    private boolean isValidJwtFormat(String token) {
        return token != null && !token.trim().isEmpty() && token.split("\\.").length == 3;
    }

    private void processToken(String token, HttpServletRequest request, Logger log) {
        try {
            String username = jwtUtil.extractUsername(token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (jwtUtil.validateToken(token, userDetails)) {
                setAuthenticationContext(userDetails, request);
                log.info("Authentification réussie pour l'utilisateur : {}", username);
            }
        } catch (MalformedJwtException e) {
            log.error("Token JWT mal formé : {}", e.getMessage());
        } catch (Exception e) {
            log.error("Erreur lors du traitement du token : {}", e.getMessage());
        }
    }

    private void setAuthenticationContext(UserDetails userDetails, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
