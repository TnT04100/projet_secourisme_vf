package net.ent.etnc.projet_secourisme_vf.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ent.etnc.projet_secourisme_vf.models.Utilisateur;
import net.ent.etnc.projet_secourisme_vf.repository.AdminRepository;
import net.ent.etnc.projet_secourisme_vf.service.CustomUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @NonNull
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Utilisateur> optionalAdmin = adminRepository.findByUsername(username);
        if (optionalAdmin.isEmpty()) {
            throw new UsernameNotFoundException("Utilisateur non trouvé : " + username);
        }
        Utilisateur utilisateur = optionalAdmin.get();
        return new User(
                utilisateur.getUsername(), utilisateur.getPassword(), new ArrayList<>()
        );
    }
}
