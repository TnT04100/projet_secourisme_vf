package net.ent.etnc.projet_secourisme_vf.service.impl;

import net.ent.etnc.projet_secourisme_vf.models.UniteEnseignement;
import net.ent.etnc.projet_secourisme_vf.repository.UniteEnseignementRepository;
import net.ent.etnc.projet_secourisme_vf.service.UniteEnseignementService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class UniteEnseignementServiceImpl extends AbstractService<UniteEnseignement, UniteEnseignementRepository, Long> implements UniteEnseignementService {
    protected UniteEnseignementServiceImpl(UniteEnseignementRepository repository) {
        super(repository);
    }

    @Override
    public void init() throws ServiceException {
        if (this.getRepository().count() == 0) {
            UniteEnseignement uniteEnseignementPSC1 = new UniteEnseignement();
            uniteEnseignementPSC1.setIntitule("PSC1");
            uniteEnseignementPSC1.setDureeFormation(8);
            uniteEnseignementPSC1.setDureeValidite(1);
            this.getRepository().save(uniteEnseignementPSC1);
            UniteEnseignement uniteEnseignementSC1 = new UniteEnseignement();
            uniteEnseignementSC1.setIntitule("SC1");
            uniteEnseignementSC1.setDureeFormation(8);
            uniteEnseignementSC1.setDureeValidite(1);
            this.getRepository().save(uniteEnseignementSC1);
        }
    }
}
