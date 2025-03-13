package net.ent.etnc.projet_secourisme_vf.service.impl;

import net.ent.etnc.projet_secourisme_vf.models.Stagiaire;
import net.ent.etnc.projet_secourisme_vf.models.repository.StagiaireRepository;
import net.ent.etnc.projet_secourisme_vf.service.StagiaireService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import org.springframework.stereotype.Service;


@Service
public class StagiaireServiceImpl extends AbstractService<Stagiaire, StagiaireRepository, Long> implements StagiaireService {
    protected StagiaireServiceImpl(StagiaireRepository repository) {
        super(repository);
    }
}
