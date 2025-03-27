package net.ent.etnc.projet_secourisme_vf.service.impl;

import net.ent.etnc.projet_secourisme_vf.models.Utilisateur;
import net.ent.etnc.projet_secourisme_vf.repository.AdminRepository;
import net.ent.etnc.projet_secourisme_vf.service.AuthService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl extends AbstractService<Utilisateur, AdminRepository, Long> implements AuthService {
    protected AuthServiceImpl(AdminRepository repository) {
        super(repository);
    }

    @Override
    public void init() throws ServiceException {
        if (this.getRepository().count() == 0) {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setUsername("admin");
            utilisateur.setPassword("admin");
            this.getRepository().save(utilisateur);
        }
    }
}
