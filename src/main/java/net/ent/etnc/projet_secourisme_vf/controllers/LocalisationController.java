package net.ent.etnc.projet_secourisme_vf.controllers;

import net.ent.etnc.projet_secourisme_vf.controllers.commons.GenericController;
import net.ent.etnc.projet_secourisme_vf.models.Localisation;
import net.ent.etnc.projet_secourisme_vf.payload.localisation.LocalisationRepresentation;
import net.ent.etnc.projet_secourisme_vf.payload.localisation.LocalisationRepresentationAssembler;
import net.ent.etnc.projet_secourisme_vf.service.LocalisationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/localisations")
public class LocalisationController extends GenericController<Localisation, Long, LocalisationRepresentation, LocalisationService, LocalisationRepresentationAssembler> {

    public LocalisationController(LocalisationService localisationService, LocalisationRepresentationAssembler localisationRepresentationAssembler) {
        super.setAssembler(localisationRepresentationAssembler);
        super.setService(localisationService);
    }
    
}
