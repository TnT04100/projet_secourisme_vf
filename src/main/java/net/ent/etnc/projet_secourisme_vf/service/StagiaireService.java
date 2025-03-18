package net.ent.etnc.projet_secourisme_vf.service;

import net.ent.etnc.projet_secourisme_vf.models.Stagiaire;
import net.ent.etnc.projet_secourisme_vf.repository.StagiaireRepository;
import net.ent.etnc.projet_secourisme_vf.service.base.ServiceGenerique;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;

public interface StagiaireService extends ServiceGenerique<Stagiaire, StagiaireRepository, Long> {
    void init() throws ServiceException;
}
