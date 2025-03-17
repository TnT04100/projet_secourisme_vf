package net.ent.etnc.projet_secourisme_vf.controllers;

import net.ent.etnc.projet_secourisme_vf.controllers.commons.GenericController;
import net.ent.etnc.projet_secourisme_vf.models.Formateur;
import net.ent.etnc.projet_secourisme_vf.payload.formateur.FormateurRepresentation;
import net.ent.etnc.projet_secourisme_vf.payload.formateur.FormateurRepresentationAssembler;
import net.ent.etnc.projet_secourisme_vf.service.FormateurService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/formateurs")
public class FormateurController extends GenericController<Formateur, Long, FormateurRepresentation, FormateurService, FormateurRepresentationAssembler> {

    public FormateurController(FormateurService formateurService, FormateurRepresentationAssembler formateurRepresentationAssembler) {
        super.setAssembler(formateurRepresentationAssembler);
        super.setService(formateurService);
    }

}
