package net.ent.etnc.projet_secourisme_vf.models;

import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;

import java.time.temporal.TemporalAmount;

public class UniteEnseignement extends AbstractPersistableWithIdSetter<Long> {
    private TemporalAmount dureeFormation;
    private String intitule;
}
