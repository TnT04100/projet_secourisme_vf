package net.ent.etnc.projet_secourisme_vf.service.impl;

import com.github.javafaker.Faker;
import net.ent.etnc.projet_secourisme_vf.models.Localisation;
import net.ent.etnc.projet_secourisme_vf.repository.LocalisationRepository;
import net.ent.etnc.projet_secourisme_vf.service.LocalisationService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class LocalisationServiceImpl extends AbstractService<Localisation, LocalisationRepository, Long> implements LocalisationService {

    private final Faker faker;

    protected LocalisationServiceImpl(LocalisationRepository repository, Faker faker) {
        super(repository);
        this.faker = faker;
    }

    @Override
    public void init() throws ServiceException {
        if (this.getRepository().count() == 0) {
            try {
                for (int i = 0; i < 500; i++) {
                    Localisation localisation = new Localisation();
                    localisation.setVille(faker.address().city());
                    localisation.setAdresse(faker.address().streetAddress());
                    localisation.setCodePostal(faker.address().zipCode());
                    localisation.setComplementAdresse(faker.address().streetAddress());
                    this.save(localisation);
                }
            } catch (Exception e) {
                throw new ServiceException(e);
            }
        }
    }
}
