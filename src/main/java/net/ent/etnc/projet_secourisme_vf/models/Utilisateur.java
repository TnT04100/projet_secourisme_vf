package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;
import net.ent.etnc.projet_secourisme_vf.models.references.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"username"})
@Table(name = "authentification", uniqueConstraints = @UniqueConstraint(name = "uk_authentification_username", columnNames = {"username"}))
public class Utilisateur extends AbstractPersistableWithIdSetter<Long> {

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(min = 1, max = 20)
    @Column(name = "username", length = 20, nullable = false)
    private String username;

    @Getter
    @NotNull
    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;

    @Getter
    @Setter
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 40)
    private Role role;

    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }
}
