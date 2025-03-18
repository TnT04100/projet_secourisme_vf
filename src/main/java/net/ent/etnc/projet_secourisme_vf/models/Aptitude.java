package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;

import java.time.LocalDate;


@Entity
@NoArgsConstructor
@ToString(of = {"dateObtention", "dateFinValidite", "uniteEnseignement"}, callSuper = true)
@Table(name = "aptitude")
public class Aptitude extends AbstractPersistableWithIdSetter<Long> {

    @Getter
    @Setter
    @Column(name = "date_obtention", nullable = false)
    private LocalDate dateObtention;

    @Getter
    @Setter
    @Column(name = "date_fin_validite", nullable = false)
    private LocalDate dateFinValidite;

    @Getter
    @Setter
    @NotNull
    @OneToOne
    @JoinColumn(name = "unite_enseignement_id", nullable = false, foreignKey = @ForeignKey(name = "fk__aptitude__unite_enseignement"))
    private UniteEnseignement uniteEnseignement;

    @PrePersist
    public void prepersist() {
        if (dateFinValidite == null) {
            dateFinValidite = dateObtention.plusYears(uniteEnseignement.getDureeValidite().longValue());
        }
        if (dateObtention == null) {
            dateObtention = LocalDate.now();
        }
    }
}
