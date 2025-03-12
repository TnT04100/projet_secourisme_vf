package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;

import java.util.Set;


@Entity
@NoArgsConstructor
@ToString(callSuper = true, of = {"certificatConditionExercice", "chefDeCellule"})
@EqualsAndHashCode(callSuper = false, of = {"certificatConditionExercice"})
@Table(name = "cellule_secourisme", uniqueConstraints = @UniqueConstraint(name = "cellule_secourisme_certificat_condition_exercice_unique", columnNames = {"certificat_condition_exercice"}))
public class CelluleSecourisme extends AbstractPersistableWithIdSetter<Long> {

    @Getter
    @Setter
    @Size(min = 1, max = 12)
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$")
    @Column(name = "certificat_condition_exercice", nullable = false, length = 12)
    private String certificatConditionExercice;

    @Getter
    @Setter
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chef_de_cellule_id", nullable = false)
    private Formateur chefDeCellule;

    @Getter
    @OneToMany
    @JoinTable(name = "cellule_secourisme_formateurs",
            joinColumns = @JoinColumn(name = "cellule_secourisme_id"),
            inverseJoinColumns = @JoinColumn(name = "formateur_id"))
    private Set<Formateur> formateurs;
}
