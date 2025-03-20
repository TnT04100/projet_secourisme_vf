package net.ent.etnc.projet_secourisme_vf.payload.stagiaire;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ent.etnc.projet_secourisme_vf.models.Aptitude;
import net.ent.etnc.projet_secourisme_vf.models.Formateur;
import net.ent.etnc.projet_secourisme_vf.models.Stagiaire;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Assembler;
import net.ent.etnc.projet_secourisme_vf.service.AptitudeService;
import net.ent.etnc.projet_secourisme_vf.service.UniteService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class StagiaireRepresentationAssembler implements Assembler<Stagiaire, StagiaireRepresentation> {

    @NonNull
    private final AptitudeService aptitudeService;
    @NonNull
    private final UniteService uniteService;

    @Override
    public StagiaireRepresentation toRepresentation(Stagiaire stagiaire) {
        return StagiaireRepresentation.builder()
                .id(stagiaire.getId())
                .numeroIdentifiantDefense(stagiaire.getNumeroIdentifiantDefense())
                .nom(stagiaire.getNom())
                .prenom(stagiaire.getPrenom())
                .dateDeNaissance(stagiaire.getDateDeNaissance())
                .villeDeNaissance(stagiaire.getVilleDeNaissance())
                .grade(stagiaire.getGrade())
                .civilite(stagiaire.getCivilite())
                .aptitudesIds(stagiaire.getAptitudes().stream().map(Aptitude::getId).toList())
                .uniteId(stagiaire.getUnite().getId())
                .build();
    }

    @Override
    public Collection<StagiaireRepresentation> toRepresentation(Collection<Stagiaire> stagiaires) {
        return stagiaires.stream()
                .map(this::toRepresentation)
                .toList();
    }

    @Override
    public Stagiaire toModel(StagiaireRepresentation stagiaireRepresentation) throws Exception {
        try {
            Formateur formateur = new Formateur();
            formateur.setId(stagiaireRepresentation.getId());
            formateur.setNumeroIdentifiantDefense(stagiaireRepresentation.getNumeroIdentifiantDefense());
            formateur.setNom(stagiaireRepresentation.getNom());
            formateur.setPrenom(stagiaireRepresentation.getPrenom());
            formateur.setDateDeNaissance(stagiaireRepresentation.getDateDeNaissance());
            formateur.setVilleDeNaissance(stagiaireRepresentation.getVilleDeNaissance());
            formateur.setCivilite(stagiaireRepresentation.getCivilite());
            for (Long aptitudeId : stagiaireRepresentation.getAptitudesIds()) {
                formateur.getAptitudes().add(aptitudeService.findById(aptitudeId).orElseThrow());
            }
            formateur.setUnite(uniteService.findById(stagiaireRepresentation.getUniteId()).orElseThrow());
            return formateur;
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de la conversion d'un FormateurRepresentation vers un Formateur", e);
        }
    }
}
