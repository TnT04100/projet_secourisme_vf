package net.ent.etnc.projet_secourisme_vf.payload.cellulesecourisme;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Representation;

import java.util.List;

@Getter
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CelluleSecourismeRepresentation implements Representation<Long> {
    private Long id;
    private String certificatConditionExercice;
    private Long chefDeCelluleId;
    private List<Long> formateursIds;
}
