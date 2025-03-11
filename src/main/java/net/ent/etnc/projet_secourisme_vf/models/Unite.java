package net.ent.etnc.projet_secourisme_vf.models;

import jakarta.persistence.Entity;
import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;

@Entity
public class Unite extends AbstractPersistableWithIdSetter<Long> {
    private String nomUnite;
    private String abreviation;
    private Localisation localisation;
}
