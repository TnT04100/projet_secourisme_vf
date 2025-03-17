package net.ent.etnc.projet_secourisme_vf.service.impl;

import net.ent.etnc.projet_secourisme_vf.models.Unite;
import net.ent.etnc.projet_secourisme_vf.repository.UniteRepository;
import net.ent.etnc.projet_secourisme_vf.service.UniteService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class UniterServiceImpl extends AbstractService<Unite, UniteRepository, Long> implements UniteService {
    protected UniterServiceImpl(UniteRepository repository) {
        super(repository);
    }
}
