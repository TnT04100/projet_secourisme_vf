package net.ent.etnc.projet_secourisme_vf.controllers;

import net.ent.etnc.projet_secourisme_vf.controllers.commons.GenericController;
import net.ent.etnc.projet_secourisme_vf.models.Aptitude;
import net.ent.etnc.projet_secourisme_vf.payload.aptitude.AptitudeRepresentation;
import net.ent.etnc.projet_secourisme_vf.payload.aptitude.AptituteRepresentationAssembler;
import net.ent.etnc.projet_secourisme_vf.service.AptitudeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/aptitudes")
public class AptitudeController extends GenericController<Aptitude, Long, AptitudeRepresentation, AptitudeService, AptituteRepresentationAssembler> {

    public AptitudeController(AptitudeService aptitudeService, AptituteRepresentationAssembler aptitudeRepresentationAssembler) {
        super.setAssembler(aptitudeRepresentationAssembler);
        super.setService(aptitudeService);
    }
}
