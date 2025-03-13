package net.ent.etnc.projet_secourisme_vf.payload.aptitude;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Representation;

import java.time.LocalDate;

@Getter
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AptitudeRepresentation implements Representation<Long> {
    private Long id;
    private LocalDate dateObtention;
    private LocalDate dateFinValidite;
    private Long uniteEnseignementId;
}
