package net.ent.etnc.projet_secourisme_vf.service.impl;

import net.ent.etnc.projet_secourisme_vf.models.CelluleSecourisme;
import net.ent.etnc.projet_secourisme_vf.repository.CelluleSecourismeRepository;
import net.ent.etnc.projet_secourisme_vf.service.CelluleSecourismeService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class CelluleSecourismeServiceImpl extends AbstractService<CelluleSecourisme, CelluleSecourismeRepository, Long> implements CelluleSecourismeService {
    protected CelluleSecourismeServiceImpl(CelluleSecourismeRepository repository) {
        super(repository);
    }

    @Override
    public void init() throws ServiceException {
        
    }
}
