package net.ent.etnc.projet_secourisme_vf.controllers;

import net.ent.etnc.projet_secourisme_vf.controllers.commons.GenericController;
import net.ent.etnc.projet_secourisme_vf.models.Formation;
import net.ent.etnc.projet_secourisme_vf.payload.formation.FormationRepresentation;
import net.ent.etnc.projet_secourisme_vf.payload.formation.FormationRepresentationAssembler;
import net.ent.etnc.projet_secourisme_vf.service.FormationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/formations")
public class FormationController extends GenericController<Formation, Long, FormationRepresentation, FormationService, FormationRepresentationAssembler> {

    public FormationController(FormationService service, FormationRepresentationAssembler assembler) {
        super.setAssembler(assembler);
        super.setService(service);
    }
}
