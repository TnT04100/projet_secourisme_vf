package net.ent.etnc.projet_secourisme_vf.service;

import net.ent.etnc.projet_secourisme_vf.models.Document;
import net.ent.etnc.projet_secourisme_vf.repository.DocumentRepository;
import net.ent.etnc.projet_secourisme_vf.service.base.ServiceGenerique;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;

public interface DocumentService extends ServiceGenerique<Document, DocumentRepository, Long> {
    void init() throws ServiceException;
}
