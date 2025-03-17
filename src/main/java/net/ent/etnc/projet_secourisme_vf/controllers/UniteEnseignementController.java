package net.ent.etnc.projet_secourisme_vf.controllers;

import net.ent.etnc.projet_secourisme_vf.controllers.commons.GenericController;
import net.ent.etnc.projet_secourisme_vf.models.UniteEnseignement;
import net.ent.etnc.projet_secourisme_vf.payload.uniteenseignement.UniteEnseignementRepresentation;
import net.ent.etnc.projet_secourisme_vf.payload.uniteenseignement.UniteEnseignementRepresentationAssembler;
import net.ent.etnc.projet_secourisme_vf.service.UniteEnseignementService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/unite-enseignements")
public class UniteEnseignementController extends GenericController<UniteEnseignement, Long, UniteEnseignementRepresentation, UniteEnseignementService, UniteEnseignementRepresentationAssembler> {

    public UniteEnseignementController(UniteEnseignementService service, UniteEnseignementRepresentationAssembler assembler) {
        super.setAssembler(assembler);
        super.setService(service);
    }

}
