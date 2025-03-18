package net.ent.etnc.projet_secourisme_vf.service;

import net.ent.etnc.projet_secourisme_vf.models.Localisation;
import net.ent.etnc.projet_secourisme_vf.repository.LocalisationRepository;
import net.ent.etnc.projet_secourisme_vf.service.base.ServiceGenerique;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;

public interface LocalisationService extends ServiceGenerique<Localisation, LocalisationRepository, Long> {
    void init() throws ServiceException;
}
