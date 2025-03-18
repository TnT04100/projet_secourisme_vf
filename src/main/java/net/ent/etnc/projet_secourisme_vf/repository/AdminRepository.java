package net.ent.etnc.projet_secourisme_vf.repository;

import net.ent.etnc.projet_secourisme_vf.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
