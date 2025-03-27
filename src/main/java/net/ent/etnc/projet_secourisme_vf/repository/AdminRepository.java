package net.ent.etnc.projet_secourisme_vf.repository;

import net.ent.etnc.projet_secourisme_vf.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByUsername(String username);
}
