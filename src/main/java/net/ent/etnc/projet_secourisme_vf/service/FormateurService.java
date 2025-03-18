package net.ent.etnc.projet_secourisme_vf.service;

import net.ent.etnc.projet_secourisme_vf.models.Formateur;
import net.ent.etnc.projet_secourisme_vf.repository.FormateurRepository;
import net.ent.etnc.projet_secourisme_vf.service.base.ServiceGenerique;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;

public interface FormateurService extends ServiceGenerique<Formateur, FormateurRepository, Long> {
    void init() throws ServiceException;
}
