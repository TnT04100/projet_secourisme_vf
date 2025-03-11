package net.ent.etnc.projet_secourisme_vf.models.references;

public enum CorpsArmee {
    ARMEE_DE_TERRE("ADT", "Armée de Terre"),
    ARMEE_DE_L_AIR_ET_ESPACE("AAE", "Armée de l'Air et de l'Espace"),
    MARINE_NATIONALE("MN", "Marine Nationale"),
    GENDARMERIE_NATIONALE("GN", "Gendarmerie Nationale"),
    CIVIL("CIV", "Personnel Civil de la Défense");


    private final String abreviation;
    private final String libelle;

    CorpsArmee(String abreviation, String libelle) {
        this.abreviation = abreviation;
        this.libelle = libelle;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", libelle, abreviation);
    }
}
