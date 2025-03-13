package net.ent.etnc.projet_secourisme_vf.controllers;

import net.ent.etnc.projet_secourisme_vf.controllers.commons.GenericController;
import net.ent.etnc.projet_secourisme_vf.models.Stagiaire;
import net.ent.etnc.projet_secourisme_vf.payload.stagiaire.StagiaireRepresentation;
import net.ent.etnc.projet_secourisme_vf.payload.stagiaire.StagiaireRepresentationAssembler;
import net.ent.etnc.projet_secourisme_vf.service.StagiaireService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stagiaires")
public class StagiaireController extends GenericController<Stagiaire, Long, StagiaireRepresentation, StagiaireService, StagiaireRepresentationAssembler> {

    public StagiaireController(StagiaireService service, StagiaireRepresentationAssembler assembler) {
        super.setAssembler(assembler);
        super.setService(service);
    }
    
}
