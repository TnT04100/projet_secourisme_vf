package net.ent.etnc.projet_secourisme_vf.models;

import net.ent.etnc.projet_secourisme_vf.models.commons.AbstractPersistableWithIdSetter;

import java.time.LocalDate;

public class Stagiaire extends AbstractPersistableWithIdSetter<Long> {
    private String numeroIdentifiantDefense;
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String villeDeNaissance;
    private String civilite;
}
