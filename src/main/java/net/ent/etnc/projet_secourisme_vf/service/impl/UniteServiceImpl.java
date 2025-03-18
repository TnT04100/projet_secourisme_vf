package net.ent.etnc.projet_secourisme_vf.service.impl;

import com.github.javafaker.Faker;
import net.ent.etnc.projet_secourisme_vf.models.Unite;
import net.ent.etnc.projet_secourisme_vf.repository.UniteRepository;
import net.ent.etnc.projet_secourisme_vf.service.LocalisationService;
import net.ent.etnc.projet_secourisme_vf.service.UniteService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class UniteServiceImpl extends AbstractService<Unite, UniteRepository, Long> implements UniteService {

    private final LocalisationService localisationService;

    private final Faker faker;

    protected UniteServiceImpl(UniteRepository repository, LocalisationService localisationService, Faker faker) {
        super(repository);
        this.localisationService = localisationService;
        this.faker = faker;
    }

    @Override
    public void init() throws ServiceException {
        try {
            if (this.getRepository().count() == 0) {
                for (int i = 0; i < 10; i++) {
                    Unite unite = new Unite();
                    String nom = faker.company().name();
                    unite.setNomUnite(nom);
                    StringBuilder abreviation = new StringBuilder();
                    String[] mots = nom.split(" ");
                    for (String mot : mots) {
                        abreviation.append(mot.charAt(0));
                    }
                    unite.setAbreviation(abreviation.toString());
                    unite.setLocalisation(localisationService.findAll().get(faker.number().numberBetween(0, (int) localisationService.count())));
                    this.save(unite);
                }
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
