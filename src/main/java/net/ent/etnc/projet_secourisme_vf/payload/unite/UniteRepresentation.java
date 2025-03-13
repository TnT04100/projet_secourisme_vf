package net.ent.etnc.projet_secourisme_vf.payload.unite;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Representation;

@Getter
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UniteRepresentation implements Representation<Long> {
    private Long id;
    private String nomUnite;
    private String abreviation;
    private Long localisationId;
}
