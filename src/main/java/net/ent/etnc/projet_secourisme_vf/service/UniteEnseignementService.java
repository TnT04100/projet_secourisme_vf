package net.ent.etnc.projet_secourisme_vf.service;

import net.ent.etnc.projet_secourisme_vf.models.UniteEnseignement;
import net.ent.etnc.projet_secourisme_vf.repository.UniteEnseignementRepository;
import net.ent.etnc.projet_secourisme_vf.service.base.ServiceGenerique;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;

public interface UniteEnseignementService extends ServiceGenerique<UniteEnseignement, UniteEnseignementRepository, Long> {
    void init() throws ServiceException;
}
