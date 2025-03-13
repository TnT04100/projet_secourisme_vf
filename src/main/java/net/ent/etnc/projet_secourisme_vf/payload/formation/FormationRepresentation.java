package net.ent.etnc.projet_secourisme_vf.payload.formation;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Representation;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormationRepresentation implements Representation<Long> {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String libelleFormation;
    private String salleFormation;
    private String codeCours;
    private Long localisationId;
    private Long uniteEnseignementId;
    private List<Long> formateursIds;
    private List<Long> stagiairesIds;
}
