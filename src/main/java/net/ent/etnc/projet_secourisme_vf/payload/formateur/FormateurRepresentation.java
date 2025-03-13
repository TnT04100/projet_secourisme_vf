package net.ent.etnc.projet_secourisme_vf.payload.formateur;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import net.ent.etnc.projet_secourisme_vf.models.references.Civilite;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Representation;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormateurRepresentation implements Representation<Long> {
    private Long id;
    private String numeroIdentifiantDefense;
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String villeDeNaissance;
    private Civilite civilite;
    private List<Long> aptitudesIds;
    private Long uniteId;
}
