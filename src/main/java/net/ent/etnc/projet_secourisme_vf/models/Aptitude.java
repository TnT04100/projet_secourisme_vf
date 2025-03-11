package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@ToString
public class Aptitude extends AbstractPersistableWithIdSetter<Long> {
    private LocalDate dateObtention;
    private LocalDate dateFinValidite;
    private UniteEnseignement uniteEnseignement;
}
