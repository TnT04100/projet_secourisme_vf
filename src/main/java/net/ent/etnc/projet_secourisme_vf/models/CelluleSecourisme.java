package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.Entity;
import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;

import java.util.Set;

@Entity
public class CelluleSecourisme extends AbstractPersistableWithIdSetter<Long> {
    private String certificatConditionExercice;
    private Formateur chefDeCellule;
    private Set<Formateur> formateurs;
}
