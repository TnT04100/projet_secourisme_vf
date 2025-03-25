package net.ent.etnc.projet_secourisme_vf.controllers;

import net.ent.etnc.projet_secourisme_vf.controllers.commons.GenericController;
import net.ent.etnc.projet_secourisme_vf.models.Formation;
import net.ent.etnc.projet_secourisme_vf.payload.formation.FormationRepresentation;
import net.ent.etnc.projet_secourisme_vf.payload.formation.FormationRepresentationAssembler;
import net.ent.etnc.projet_secourisme_vf.service.FormationService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/formations")
public class FormationController extends GenericController<Formation, Long, FormationRepresentation, FormationService, FormationRepresentationAssembler> {

    public FormationController(FormationService service, FormationRepresentationAssembler assembler) {
        super.setAssembler(assembler);
        super.setService(service);
    }


    @GetMapping("/count/completed")
    public long countCompletedFormations() {
        return service.countCompletedFormations();
    }

    @GetMapping("/count/total")
    public long countTotalFormations() {
        return service.countTotalFormations();
    }

    @GetMapping("/count/formateur/{formateurId}")
    public long countFormationsByFormateurId(@PathVariable Long formateurId) {
        return service.countFormationsByFormateurId(formateurId);
    }

    @GetMapping("/count/stagiaire/{stagiaireId}")
    public long countFormationsByStagiaireId(@PathVariable Long stagiaireId) {
        return service.countFormationsByStagiaireId(stagiaireId);
    }
}
