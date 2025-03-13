package net.ent.etnc.projet_secourisme_vf.payload.localisation;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Representation;

@Getter
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocalisationRepresentation implements Representation<Long> {
    private Long id;
    private String ville;
    private String codePostal;
    private String adresse;
    private String complementAdresse;
}
