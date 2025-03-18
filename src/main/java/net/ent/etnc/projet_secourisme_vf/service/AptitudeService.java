package net.ent.etnc.projet_secourisme_vf.service;

import net.ent.etnc.projet_secourisme_vf.models.Aptitude;
import net.ent.etnc.projet_secourisme_vf.repository.AptitudeRepository;
import net.ent.etnc.projet_secourisme_vf.service.base.ServiceGenerique;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;

public interface AptitudeService extends ServiceGenerique<Aptitude, AptitudeRepository, Long> {
    void init() throws ServiceException;
}
