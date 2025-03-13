package net.ent.etnc.projet_secourisme_vf.payload.cellulesecourisme;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ent.etnc.projet_secourisme_vf.models.CelluleSecourisme;
import net.ent.etnc.projet_secourisme_vf.models.Formateur;
import net.ent.etnc.projet_secourisme_vf.payload.commons.Assembler;
import net.ent.etnc.projet_secourisme_vf.service.FormateurService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class CelluleSecourismeRepresentationAssembler implements Assembler<CelluleSecourisme, CelluleSecourismeRepresentation> {

    @NonNull
    private final FormateurService formateurService;

    @Override
    public CelluleSecourismeRepresentation toRepresentation(CelluleSecourisme celluleSecourisme) {
        return CelluleSecourismeRepresentation.builder()
                .id(celluleSecourisme.getId())
                .certificatConditionExercice(celluleSecourisme.getCertificatConditionExercice())
                .chefDeCelluleId(celluleSecourisme.getChefDeCellule().getId())
                .formateursIds(celluleSecourisme.getFormateurs().stream().map(Formateur::getId).toList())
                .build();
    }

    @Override
    public Collection<CelluleSecourismeRepresentation> toRepresentation(Collection<CelluleSecourisme> celluleSecourismes) {
        return celluleSecourismes.stream()
                .map(this::toRepresentation)
                .toList();
    }

    @Override
    public CelluleSecourisme toModel(CelluleSecourismeRepresentation celluleSecourismeRepresentation) throws Exception {
        try {
            CelluleSecourisme celluleSecourisme = new CelluleSecourisme();
            celluleSecourisme.setId(celluleSecourismeRepresentation.getId());
            celluleSecourisme.setCertificatConditionExercice(celluleSecourismeRepresentation.getCertificatConditionExercice());
            celluleSecourisme.setChefDeCellule(formateurService.findById(celluleSecourismeRepresentation.getChefDeCelluleId()).orElseThrow());
            for (Long formateurId : celluleSecourismeRepresentation.getFormateursIds()) {
                celluleSecourisme.getFormateurs().add(formateurService.findById(formateurId).orElseThrow());
            }
            return celluleSecourisme;
        } catch (Exception e) {
            throw new ServiceException("Erreur lors de la conversion d'un CelluleSecourismeRepresentation vers un CelluleSecourisme", e);
        }
    }
}
