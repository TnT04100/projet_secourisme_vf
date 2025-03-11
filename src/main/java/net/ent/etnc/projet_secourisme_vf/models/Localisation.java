package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;

@Entity
@NoArgsConstructor
@ToString(callSuper = true, of = {"ville", "codePostal", "adresse", "complementAdresse"})
@EqualsAndHashCode(of = {"ville", "codePostal", "adresse", "complementAdresse"}, callSuper = false)
@Table(name = "localisation")
public class Localisation extends AbstractPersistableWithIdSetter<Long> {

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(max = 45)
    // Car la ville la plus longue de France est "Saint-Remy-en-Bouzemont-Saint-Genest-et-Isson" avec 45 caractères
    @Column(name = "ville", length = 45, nullable = false)
    private String ville;

    @Getter
    @Setter
    @Pattern(regexp = "^[0-9]{5}$")
    @Column(name = "code_postal", length = 5, nullable = false)
    private String codePostal;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "adresse", length = 100, nullable = false)
    private String adresse;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "complement_adresse", length = 100, nullable = false)
    private String complementAdresse;
}
