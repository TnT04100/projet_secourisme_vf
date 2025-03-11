package net.ent.etnc.projet_secourisme_vf.models;

import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;

public class Localisation extends AbstractPersistableWithIdSetter<Long> {
    private String ville;
    private String codePostal;
    private String adresse;
    private String complementAdresse;
}
