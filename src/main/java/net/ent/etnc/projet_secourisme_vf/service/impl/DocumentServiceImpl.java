package net.ent.etnc.projet_secourisme_vf.service.impl;

import net.ent.etnc.projet_secourisme_vf.models.Document;
import net.ent.etnc.projet_secourisme_vf.repository.DocumentRepository;
import net.ent.etnc.projet_secourisme_vf.service.DocumentService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;

public class DocumentServiceImpl extends AbstractService<Document, DocumentRepository, Long> implements DocumentService {
    
    protected DocumentServiceImpl(DocumentRepository repository) {
        super(repository);
    }
}
