package net.ent.etnc.projet_secourisme_vf.payload.uniteenseignement;

import net.ent.etnc.projet_secourisme_vf.models.UniteEnseignement;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Assembler;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class UniteEnseignementRepresentationAssembler implements Assembler<UniteEnseignement, UniteEnseignementRepresentation> {
    @Override
    public UniteEnseignementRepresentation toRepresentation(UniteEnseignement uniteEnseignement) {
        return UniteEnseignementRepresentation.builder()
                .id(uniteEnseignement.getId())
                .dureeFormation(uniteEnseignement.getDureeFormation())
                .dureeValidite(uniteEnseignement.getDureeValidite())
                .intitule(uniteEnseignement.getIntitule())
                .build();
    }

    @Override
    public Collection<UniteEnseignementRepresentation> toRepresentation(Collection<UniteEnseignement> uniteEnseignements) {
        return uniteEnseignements.stream()
                .map(this::toRepresentation)
                .toList();
    }

    @Override
    public UniteEnseignement toModel(UniteEnseignementRepresentation uniteEnseignementRepresentation) throws Exception {
        try {
            UniteEnseignement uniteEnseignement = new UniteEnseignement();
            uniteEnseignement.setId(uniteEnseignementRepresentation.getId());
            uniteEnseignement.setDureeFormation(uniteEnseignementRepresentation.getDureeFormation());
            uniteEnseignement.setDureeValidite(uniteEnseignementRepresentation.getDureeValidite());
            uniteEnseignement.setIntitule(uniteEnseignementRepresentation.getIntitule());
            return uniteEnseignement;
        } catch (Exception e) {
            throw new ServiceException("Erreur de conversion du UniteEnseignementRepresentation vers UniteEnseignement", e);
        }
    }
}
