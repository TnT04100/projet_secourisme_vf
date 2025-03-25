package net.ent.etnc.projet_secourisme_vf.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ent.etnc.projet_secourisme_vf.models.Admin;
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
        Optional<Admin> optionalAdmin = adminRepository.findByUsername(username);
        if (optionalAdmin.isEmpty()) {
            throw new UsernameNotFoundException("Utilisateur non trouvé : " + username);
        }
        Admin admin = optionalAdmin.get();
        System.out.println("Loading user : " + admin.getUsername());
        return new User(
                admin.getUsername(), admin.getPassword(), new ArrayList<>()
        );
    }
}
