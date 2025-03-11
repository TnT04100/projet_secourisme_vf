package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;

import java.time.LocalDate;

@Entity
public class Formation extends AbstractPersistableWithIdSetter<Long> {
    @Getter
    @Setter
    @NotNull
    @Future
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String libelleFormation;
    private String salleFormation;
    private String codeCours;
}
