package net.ent.etnc.projet_secourisme_vf.service.impl;

import com.github.javafaker.Faker;
import net.ent.etnc.projet_secourisme_vf.models.Aptitude;
import net.ent.etnc.projet_secourisme_vf.repository.AptitudeRepository;
import net.ent.etnc.projet_secourisme_vf.service.AptitudeService;
import net.ent.etnc.projet_secourisme_vf.service.UniteEnseignementService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class AptitudeServiceImpl extends AbstractService<Aptitude, AptitudeRepository, Long> implements AptitudeService {

    private final UniteEnseignementService uniteEnseignementService;
    private final Faker faker;

    protected AptitudeServiceImpl(AptitudeRepository repository, UniteEnseignementService uniteEnseignementService, Faker faker) {
        super(repository);
        this.uniteEnseignementService = uniteEnseignementService;
        this.faker = faker;
    }

    @Override
    public void init() throws ServiceException {
        if (this.getRepository().count() == 0) {
            Aptitude aptitude = new Aptitude();

            this.save(aptitude);
        }
    }
}
