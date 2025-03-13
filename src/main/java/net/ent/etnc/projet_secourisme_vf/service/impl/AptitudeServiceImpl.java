package net.ent.etnc.projet_secourisme_vf.service.impl;

import net.ent.etnc.projet_secourisme_vf.models.Aptitude;
import net.ent.etnc.projet_secourisme_vf.models.repository.AptitudeRepository;
import net.ent.etnc.projet_secourisme_vf.service.AptitudeService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class AptitudeServiceImpl extends AbstractService<Aptitude, AptitudeRepository, Long> implements AptitudeService {
    protected AptitudeServiceImpl(AptitudeRepository repository) {
        super(repository);
    }
}
