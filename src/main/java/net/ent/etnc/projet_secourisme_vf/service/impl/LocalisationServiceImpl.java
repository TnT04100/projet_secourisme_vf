package net.ent.etnc.projet_secourisme_vf.service.impl;

import net.ent.etnc.projet_secourisme_vf.models.Localisation;
import net.ent.etnc.projet_secourisme_vf.repository.LocalisationRepository;
import net.ent.etnc.projet_secourisme_vf.service.LocalisationService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class LocalisationServiceImpl extends AbstractService<Localisation, LocalisationRepository, Long> implements LocalisationService {
    protected LocalisationServiceImpl(LocalisationRepository repository) {
        super(repository);
    }
}
