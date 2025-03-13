package net.ent.etnc.projet_secourisme_vf.payload.unite;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ent.etnc.projet_secourisme_vf.models.Unite;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Assembler;
import net.ent.etnc.projet_secourisme_vf.service.LocalisationService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class UniteRepresentationAssembler implements Assembler<Unite, UniteRepresentation> {

    @NonNull
    private final LocalisationService localisationService;

    @Override
    public UniteRepresentation toRepresentation(Unite unite) {
        return UniteRepresentation.builder()
                .id(unite.getId())
                .nomUnite(unite.getNomUnite())
                .abreviation(unite.getAbreviation())
                .localisationId(unite.getLocalisation().getId())
                .build();
    }

    @Override
    public Collection<UniteRepresentation> toRepresentation(Collection<Unite> unites) {
        return unites.stream()
                .map(this::toRepresentation)
                .toList();
    }

    @Override
    public Unite toModel(UniteRepresentation uniteRepresentation) throws Exception {
        try {
            Unite unite = new Unite();
            unite.setId(uniteRepresentation.getId());
            unite.setNomUnite(uniteRepresentation.getNomUnite());
            unite.setAbreviation(uniteRepresentation.getAbreviation());
            unite.setLocalisation(localisationService.findById(uniteRepresentation.getLocalisationId()).orElseThrow());
            return unite;
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de la conversion d'un UniteRepresentation vers un Unite", e);
        }
    }
}
