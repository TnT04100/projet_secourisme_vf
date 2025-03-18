package net.ent.etnc.projet_secourisme_vf.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ent.etnc.projet_secourisme_vf.models.Admin;
import net.ent.etnc.projet_secourisme_vf.repository.AdminRepository;
import net.ent.etnc.projet_secourisme_vf.service.CustomUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @NonNull
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByUsername(username);
        if (admin == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé : " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                admin.getUsername(), admin.getPassword(), new ArrayList<>()
        );
    }
}
