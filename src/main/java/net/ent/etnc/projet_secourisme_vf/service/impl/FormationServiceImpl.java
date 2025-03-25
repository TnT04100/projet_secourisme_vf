package net.ent.etnc.projet_secourisme_vf.service.impl;

import net.ent.etnc.projet_secourisme_vf.models.Formation;
import net.ent.etnc.projet_secourisme_vf.repository.FormationRepository;
import net.ent.etnc.projet_secourisme_vf.service.FormationService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class FormationServiceImpl extends AbstractService<Formation, FormationRepository, Long> implements FormationService {
    private final FormationRepository formationRepository;

    protected FormationServiceImpl(FormationRepository repository, FormationRepository formationRepository) {
        super(repository);
        this.formationRepository = formationRepository;
    }

    @Override
    public void init() throws ServiceException {
        // TODO document why this method is empty
    }

    @Override
    public long countCompletedFormations() {
        return formationRepository.countCompletedFormations();
    }

    @Override
    public long countTotalFormations() {
        return formationRepository.countTotalFormations();
    }

    @Override
    public long countFormationsByFormateurId(Long formateurId) {
        return formationRepository.countFormationsByFormateurId(formateurId);
    }

    @Override
    public long countFormationsByStagiaireId(Long stagiaireId) {
        return formationRepository.countFormationsByStagiaireId(stagiaireId);
    }
}
