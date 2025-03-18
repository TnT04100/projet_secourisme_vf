package net.ent.etnc.projet_secourisme_vf.service.impl;

import com.github.javafaker.Faker;
import net.ent.etnc.projet_secourisme_vf.models.Document;
import net.ent.etnc.projet_secourisme_vf.repository.DocumentRepository;
import net.ent.etnc.projet_secourisme_vf.service.DocumentService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;

public class DocumentServiceImpl extends AbstractService<Document, DocumentRepository, Long> implements DocumentService {

    private final Faker faker;


    protected DocumentServiceImpl(DocumentRepository repository, Faker faker) {
        super(repository);
        this.faker = faker;
    }

    @Override
    public void init() throws ServiceException {
        if (this.getRepository().count() == 0) {
            Document document = new Document();
            document.setNom(faker.lorem().word());
            document.setChemin();

            this.save(document);
        }
    }
}
