package net.ent.etnc.projet_secourisme_vf.payload.uniteenseignement;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Representation;

@Getter
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UniteEnseignementRepresentation implements Representation<Long> {
    private Long id;
    private Integer dureeFormation;
    private Integer dureeValidite;
    private String intitule;
}
