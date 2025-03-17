package net.ent.etnc.projet_secourisme_vf.payload.localisation;

import net.ent.etnc.projet_secourisme_vf.models.Localisation;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Assembler;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class LocalisationRepresentationAssembler implements Assembler<Localisation, LocalisationRepresentation> {

    @Override
    public LocalisationRepresentation toRepresentation(Localisation localisation) {
        return LocalisationRepresentation.builder()
                .id(localisation.getId())
                .ville(localisation.getVille())
                .codePostal(localisation.getCodePostal())
                .adresse(localisation.getAdresse())
                .complementAdresse(localisation.getComplementAdresse())
                .build();
    }

    @Override
    public Collection<LocalisationRepresentation> toRepresentation(Collection<Localisation> localisations) {
        return localisations.stream()
                .map(this::toRepresentation)
                .toList();
    }

    @Override
    public Localisation toModel(LocalisationRepresentation localisationRepresentation) throws Exception {
        try {
            Localisation localisation = new Localisation();
            localisation.setId(localisationRepresentation.getId());
            localisation.setVille(localisationRepresentation.getVille());
            localisation.setCodePostal(localisationRepresentation.getCodePostal());
            localisation.setAdresse(localisationRepresentation.getAdresse());
            localisation.setComplementAdresse(localisationRepresentation.getComplementAdresse());
            return localisation;
        } catch (Exception e) {
            throw new ServiceException("Erreur de conversion du LocalisationRepresentation vers Localisation", e);
        }
    }
}
