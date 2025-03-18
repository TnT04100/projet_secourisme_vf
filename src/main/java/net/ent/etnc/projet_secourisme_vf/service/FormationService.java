package net.ent.etnc.projet_secourisme_vf.service;

import net.ent.etnc.projet_secourisme_vf.models.Formation;
import net.ent.etnc.projet_secourisme_vf.repository.FormationRepository;
import net.ent.etnc.projet_secourisme_vf.service.base.ServiceGenerique;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;

public interface FormationService extends ServiceGenerique<Formation, FormationRepository, Long> {
    void init() throws ServiceException;
}
