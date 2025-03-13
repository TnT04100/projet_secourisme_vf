package net.ent.etnc.projet_secourisme_vf.payload.formateur;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ent.etnc.projet_secourisme_vf.models.Aptitude;
import net.ent.etnc.projet_secourisme_vf.models.Formateur;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Assembler;
import net.ent.etnc.projet_secourisme_vf.service.AptitudeService;
import net.ent.etnc.projet_secourisme_vf.service.UniteService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class FormateurRepresentationAssembler implements Assembler<Formateur, FormateurRepresentation> {

    @NonNull
    private final AptitudeService aptitudeService;
    @NonNull
    private final UniteService uniteService;

    @Override
    public FormateurRepresentation toRepresentation(Formateur formateur) {
        return FormateurRepresentation.builder()
                .id(formateur.getId())
                .numeroIdentifiantDefense(formateur.getNumeroIdentifiantDefense())
                .nom(formateur.getNom())
                .prenom(formateur.getPrenom())
                .dateDeNaissance(formateur.getDateDeNaissance())
                .villeDeNaissance(formateur.getVilleDeNaissance())
                .civilite(formateur.getCivilite())
                .aptitudesIds(formateur.getAptitudes().stream().map(Aptitude::getId).toList())
                .uniteId(formateur.getUnite().getId())
                .build();
    }

    @Override
    public Collection<FormateurRepresentation> toRepresentation(Collection<Formateur> formateurs) {
        return formateurs.stream()
                .map(this::toRepresentation)
                .toList();
    }

    @Override
    public Formateur toModel(FormateurRepresentation formateurRepresentation) throws Exception {
        try {
            Formateur formateur = new Formateur();
            formateur.setId(formateurRepresentation.getId());
            formateur.setNumeroIdentifiantDefense(formateurRepresentation.getNumeroIdentifiantDefense());
            formateur.setNom(formateurRepresentation.getNom());
            formateur.setPrenom(formateurRepresentation.getPrenom());
            formateur.setDateDeNaissance(formateurRepresentation.getDateDeNaissance());
            formateur.setVilleDeNaissance(formateurRepresentation.getVilleDeNaissance());
            formateur.setCivilite(formateurRepresentation.getCivilite());
            for (Long aptitudeId : formateurRepresentation.getAptitudesIds()) {
                formateur.getAptitudes().add(aptitudeService.findById(aptitudeId).orElseThrow());
            }
            formateur.setUnite(uniteService.findById(formateurRepresentation.getUniteId()).orElseThrow());
            return formateur;
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de la conversion d'un FormateurRepresentation vers un Formateur", e);
        }
    }
}
