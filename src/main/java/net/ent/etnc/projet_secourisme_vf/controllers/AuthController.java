package net.ent.etnc.projet_secourisme_vf.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ent.etnc.projet_secourisme_vf.service.CustomUserDetailsService;
import net.ent.etnc.projet_secourisme_vf.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/auth")
public class AuthController {

    @NonNull
    private AuthenticationManager authenticationManager;

    @NonNull
    private JwtUtil jwtUtil;

    @NonNull
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            System.out.println("Login success");
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Identifiants invalides");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);
        System.out.println("Token generated : " + jwt);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
}

