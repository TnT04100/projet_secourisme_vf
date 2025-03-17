package net.ent.etnc.projet_secourisme_vf.controllers;

import net.ent.etnc.projet_secourisme_vf.controllers.commons.GenericController;
import net.ent.etnc.projet_secourisme_vf.models.Unite;
import net.ent.etnc.projet_secourisme_vf.payload.unite.UniteRepresentation;
import net.ent.etnc.projet_secourisme_vf.payload.unite.UniteRepresentationAssembler;
import net.ent.etnc.projet_secourisme_vf.service.UniteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/unites")
public class UniteController extends GenericController<Unite, Long, UniteRepresentation, UniteService, UniteRepresentationAssembler> {

    public UniteController(UniteService service, UniteRepresentationAssembler assembler) {
        super.setAssembler(assembler);
        super.setService(service);
    }
}
