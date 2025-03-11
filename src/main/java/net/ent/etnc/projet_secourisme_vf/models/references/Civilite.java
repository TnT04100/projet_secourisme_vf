package net.ent.etnc.projet_secourisme_vf.models.references;

public enum Civilite {
    MONSIEUR("Monsieur"),
    MADAME("Madame"),
    AUTRE("Autre");

    private final String libelle;

    private Civilite(String libelle) {
        this.libelle = libelle;
    }
}
