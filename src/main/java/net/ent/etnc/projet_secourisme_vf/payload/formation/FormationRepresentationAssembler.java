package net.ent.etnc.projet_secourisme_vf.payload.formation;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ent.etnc.projet_secourisme_vf.models.Formateur;
import net.ent.etnc.projet_secourisme_vf.models.Formation;
import net.ent.etnc.projet_secourisme_vf.models.Stagiaire;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Assembler;
import net.ent.etnc.projet_secourisme_vf.service.*;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class FormationRepresentationAssembler implements Assembler<Formation, FormationRepresentation> {

    @NonNull
    private final LocalisationService localisationService;

    @NonNull
    private final UniteEnseignementService uniteEnseignementService;

    @NonNull
    private final FormateurService formateurService;

    @NonNull
    private final StagiaireService stagiaireService;
    private final FormationService formationService;

    @Override
    public FormationRepresentation toRepresentation(Formation formation) {
        return FormationRepresentation.builder()
                .id(formation.getId())
                .dateDebut(formation.getDateDebut())
                .dateFin(formation.getDateFin())
                .libelleFormation(formation.getLibelleFormation())
                .salleFormation(formation.getSalleFormation())
                .codeCours(formation.getCodeCours())
                .localisationId(formation.getLocalisation().getId())
                .uniteEnseignementId(formation.getUniteEnseignement().getId())
                .formateursIds(formation.getFormateurs().stream().map(Formateur::getId).toList())
                .stagiairesIds(formation.getStagiaires().stream().map(Stagiaire::getId).toList())
                .build();
    }

    @Override
    public Collection<FormationRepresentation> toRepresentation(Collection<Formation> formations) {
        return formations.stream()
                .map(this::toRepresentation)
                .toList();
    }

    @Override
    public Formation toModel(FormationRepresentation formationRepresentation) throws Exception {
        try {
            Formation formation = new Formation();
            formation.setId(formationRepresentation.getId());
            formation.setDateDebut(formationRepresentation.getDateDebut());
            formation.setDateFin(formationRepresentation.getDateFin());
            formation.setLibelleFormation(formationRepresentation.getLibelleFormation());
            formation.setSalleFormation(formationRepresentation.getSalleFormation());
            formation.setCodeCours(formationRepresentation.getCodeCours());
            formation.setLocalisation(localisationService.findById(formationRepresentation.getLocalisationId()).orElseThrow());
            formation.setUniteEnseignement(uniteEnseignementService.findById(formationRepresentation.getUniteEnseignementId()).orElseThrow());
            for (Long formateurId : formationRepresentation.getFormateursIds()) {
                formation.getFormateurs().add(formateurService.findById(formateurId).orElseThrow());
            }
            for (Long stagiaireId : formationRepresentation.getStagiairesIds()) {
                formation.getStagiaires().add(stagiaireService.findById(stagiaireId).orElseThrow());
            }
            return formation;
        } catch (Exception e) {
            throw new ServiceException("Erreur de conversion du FormationRepresentation vers Formation", e);
        }
    }
}
