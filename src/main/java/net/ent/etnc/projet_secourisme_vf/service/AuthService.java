package net.ent.etnc.projet_secourisme_vf.service;

import net.ent.etnc.projet_secourisme_vf.models.Admin;
import net.ent.etnc.projet_secourisme_vf.repository.AdminRepository;
import net.ent.etnc.projet_secourisme_vf.service.base.ServiceGenerique;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;

public interface AuthService extends ServiceGenerique<Admin, AdminRepository, Long> {
    void init() throws ServiceException;
}
