package net.ent.etnc.projet_secourisme_vf.controllers;

import net.ent.etnc.projet_secourisme_vf.controllers.commons.GenericController;
import net.ent.etnc.projet_secourisme_vf.models.CelluleSecourisme;
import net.ent.etnc.projet_secourisme_vf.payload.cellulesecourisme.CelluleSecourismeRepresentation;
import net.ent.etnc.projet_secourisme_vf.payload.cellulesecourisme.CelluleSecourismeRepresentationAssembler;
import net.ent.etnc.projet_secourisme_vf.service.CelluleSecourismeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cellule-secourismes")
public class CelluleSecourismeController extends GenericController<CelluleSecourisme, Long, CelluleSecourismeRepresentation, CelluleSecourismeService, CelluleSecourismeRepresentationAssembler> {

    public CelluleSecourismeController(CelluleSecourismeService celluleSecourismeService, CelluleSecourismeRepresentationAssembler celluleSecourismeRepresentationAssembler) {
        super.setAssembler(celluleSecourismeRepresentationAssembler);
        super.setService(celluleSecourismeService);
    }
    
}
