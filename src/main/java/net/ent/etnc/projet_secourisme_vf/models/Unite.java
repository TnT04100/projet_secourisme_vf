package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;


@Entity
@NoArgsConstructor
@ToString(of = {"nomUnite", "abreviation", "localisation"}, callSuper = true)
@EqualsAndHashCode(of = {"nomUnite"}, callSuper = false)
@Table(name = "unite", uniqueConstraints = @UniqueConstraint(name = "uk_unite_nom_unite", columnNames = {"nom_unite"}))
public class Unite extends AbstractPersistableWithIdSetter<Long> {

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "nom_unite", length = 100, nullable = false)
    private String nomUnite;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(min = 1, max = 15)
    @Column(name = "abreviation", length = 15, nullable = false)
    private String abreviation;

    @Getter
    @Setter
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "localisation_id", nullable = false)
    private Localisation localisation;
}
