package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"username"})
@Table(name = "authentification", uniqueConstraints = @UniqueConstraint(name = "uk_authentification_username", columnNames = {"username"}))
public class Admin extends AbstractPersistableWithIdSetter<Long> {

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

    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }
}
