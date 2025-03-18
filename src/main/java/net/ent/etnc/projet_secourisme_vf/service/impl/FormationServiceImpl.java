package net.ent.etnc.projet_secourisme_vf.service.impl;

import net.ent.etnc.projet_secourisme_vf.models.Formation;
import net.ent.etnc.projet_secourisme_vf.repository.FormationRepository;
import net.ent.etnc.projet_secourisme_vf.service.FormationService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class FormationServiceImpl extends AbstractService<Formation, FormationRepository, Long> implements FormationService {
    protected FormationServiceImpl(FormationRepository repository) {
        super(repository);
    }

    @Override
    public void init() throws ServiceException {
        // TODO document why this method is empty
    }
}
