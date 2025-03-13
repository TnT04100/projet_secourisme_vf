package net.ent.etnc.projet_secourisme_vf.payload.aptitude;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ent.etnc.projet_secourisme_vf.models.Aptitude;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Assembler;
import net.ent.etnc.projet_secourisme_vf.service.UniteEnseignementService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class AptituteRepresentationAssembler implements Assembler<Aptitude, AptitudeRepresentation> {

    @NonNull
    private final UniteEnseignementService uniteEnseignementService;

    @Override
    public AptitudeRepresentation toRepresentation(Aptitude aptitude) {
        return AptitudeRepresentation.builder()
                .id(aptitude.getId())
                .dateObtention(aptitude.getDateObtention())
                .dateFinValidite(aptitude.getDateFinValidite())
                .uniteEnseignementId(aptitude.getUniteEnseignement().getId())
                .build();
    }

    @Override
    public Collection<AptitudeRepresentation> toRepresentation(Collection<Aptitude> aptitudes) {
        return aptitudes.stream()
                .map(this::toRepresentation)
                .toList();
    }

    @Override
    public Aptitude toModel(AptitudeRepresentation aptitudeRepresentation) throws Exception {
        try {
            Aptitude aptitude = new Aptitude();
            aptitude.setId(aptitudeRepresentation.getId());
            aptitude.setDateObtention(aptitudeRepresentation.getDateObtention());
            aptitude.setDateFinValidite(aptitudeRepresentation.getDateFinValidite());
            aptitude.setUniteEnseignement(uniteEnseignementService.findById(aptitudeRepresentation.getUniteEnseignementId()).orElseThrow());
            return aptitude;
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de la conversion d'un AptitudeRepresentation vers un Aptitude", e);
        }
    }
}
