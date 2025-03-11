package net.ent.etnc.projet_secourisme_vf.models.references;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Armee {
    ADT("Armée de Terre"),
    AAE("Armée de l'Air et de l'Espace"),
    MN("Marine Nationale");

    private final String libelle;


}
