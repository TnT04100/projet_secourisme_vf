package net.ent.etnc.projet_secourisme_vf.service.impl;

import net.ent.etnc.projet_secourisme_vf.models.Formateur;
import net.ent.etnc.projet_secourisme_vf.models.repository.FormateurRepository;
import net.ent.etnc.projet_secourisme_vf.service.FormateurService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class FormateurServiceImpl extends AbstractService<Formateur, FormateurRepository, Long> implements FormateurService {
    protected FormateurServiceImpl(FormateurRepository repository) {
        super(repository);
    }
}
