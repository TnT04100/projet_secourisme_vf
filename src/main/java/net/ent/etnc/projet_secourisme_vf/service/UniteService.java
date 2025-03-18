package net.ent.etnc.projet_secourisme_vf.service;

import net.ent.etnc.projet_secourisme_vf.models.Unite;
import net.ent.etnc.projet_secourisme_vf.repository.UniteRepository;
import net.ent.etnc.projet_secourisme_vf.service.base.ServiceGenerique;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;

public interface UniteService extends ServiceGenerique<Unite, UniteRepository, Long> {
    void init() throws ServiceException;
}
