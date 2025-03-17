package net.ent.etnc.projet_secourisme_vf.service.impl;

import net.ent.etnc.projet_secourisme_vf.models.UniteEnseignement;
import net.ent.etnc.projet_secourisme_vf.repository.UniteEnseignementRepository;
import net.ent.etnc.projet_secourisme_vf.service.UniteEnseignementService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class UniteEnseignementServiceImpl extends AbstractService<UniteEnseignement, UniteEnseignementRepository, Long> implements UniteEnseignementService {
    protected UniteEnseignementServiceImpl(UniteEnseignementRepository repository) {
        super(repository);
    }
}
