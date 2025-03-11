package net.ent.etnc.projet_secourisme_vf.models.references;

public enum ServiceMinisteriel {

    // Corps d'armée principaux
    ARMEE_DE_TERRE("Armée de Terre"),
    MARINE_NATIONALE("Marine Nationale"),
    ARMEE_AIR_ESPACE("Armée de l'Air et de l'Espace"),
    GENDARMERIE_NATIONALE("Gendarmerie Nationale"),

    // Directions et services interarmées
    DGA("Direction Générale de l'Armement"),
    DRM("Direction du Renseignement Militaire"),
    DGSE("Direction Générale de la Sécurité Extérieure"),
    DRSD("Direction du Renseignement et de la Sécurité de la Défense"),
    SHD("Service Historique de la Défense"),
    SSA("Service de Santé des Armées"),
    SEA("Service des Essences des Armées"),
    SCA("Service du Commissariat des Armées"),
    SID("Service d'Infrastructure de la Défense"),
    SIMMT("Structure Intégrée du Maintien en condition opérationnelle des Matériels Terrestres"),
    DIRISI("Direction Interarmées des Réseaux d'Infrastructure et des Systèmes d'Information");

    private final String libelle;

    ServiceMinisteriel(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
