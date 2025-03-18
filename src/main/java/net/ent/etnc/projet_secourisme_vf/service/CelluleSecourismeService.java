package net.ent.etnc.projet_secourisme_vf.service;

import net.ent.etnc.projet_secourisme_vf.models.CelluleSecourisme;
import net.ent.etnc.projet_secourisme_vf.repository.CelluleSecourismeRepository;
import net.ent.etnc.projet_secourisme_vf.service.base.ServiceGenerique;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;

public interface CelluleSecourismeService extends ServiceGenerique<CelluleSecourisme, CelluleSecourismeRepository, Long> {
    void init() throws ServiceException;
}
