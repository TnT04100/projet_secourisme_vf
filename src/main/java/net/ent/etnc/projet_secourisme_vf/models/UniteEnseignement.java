package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;

@Entity
@NoArgsConstructor
@ToString(of = {"dureeFormation", "dureeValidite", "intitule"})
@Table(name = "unite_enseignement")
public class UniteEnseignement extends AbstractPersistableWithIdSetter<Long> {

    @Getter
    @Setter
    @NotNull
    @Positive
    @Column(name = "duree_formation", nullable = false)
    private Integer dureeFormation;

    @Getter
    @Setter
    @NotNull
    @Positive
    @Column(name = "duree_validite", nullable = false)
    private Integer dureeValidite;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    @Column(name = "intitule", length = 50, nullable = false)
    private String intitule;
}
