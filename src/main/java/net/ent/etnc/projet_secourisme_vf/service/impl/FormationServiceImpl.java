package net.ent.etnc.projet_secourisme_vf.service.impl;

import net.ent.etnc.projet_secourisme_vf.models.Formation;
import net.ent.etnc.projet_secourisme_vf.models.repository.FormationRepository;
import net.ent.etnc.projet_secourisme_vf.service.FormationService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class FormationServiceImpl extends AbstractService<Formation, FormationRepository, Long> implements FormationService {
    protected FormationServiceImpl(FormationRepository repository) {
        super(repository);
    }
}
