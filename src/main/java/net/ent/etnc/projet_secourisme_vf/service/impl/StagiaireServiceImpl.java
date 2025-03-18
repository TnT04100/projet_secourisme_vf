package net.ent.etnc.projet_secourisme_vf.service.impl;

import com.github.javafaker.Faker;
import net.ent.etnc.projet_secourisme_vf.models.Stagiaire;
import net.ent.etnc.projet_secourisme_vf.models.references.Civilite;
import net.ent.etnc.projet_secourisme_vf.repository.StagiaireRepository;
import net.ent.etnc.projet_secourisme_vf.service.StagiaireService;
import net.ent.etnc.projet_secourisme_vf.service.UniteService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Service;

import java.time.ZoneId;


@Service
public class StagiaireServiceImpl extends AbstractService<Stagiaire, StagiaireRepository, Long> implements StagiaireService {

    private final UniteService uniteService;

    private final Faker faker;

    protected StagiaireServiceImpl(StagiaireRepository repository, Faker faker, UniteService uniteService) {
        super(repository);
        this.faker = faker;
        this.uniteService = uniteService;
    }

    @Override
    public void init() throws ServiceException {
        if (this.getRepository().count() == 0) {
            try {
                for (int i = 0; i < 100; i++) {
                    Stagiaire stagiaire = new Stagiaire();
                    stagiaire.setNumeroIdentifiantDefense(faker.regexify("[0-9]{10}"));
                    stagiaire.setNom(faker.name().lastName());
                    stagiaire.setPrenom(faker.name().firstName());
                    stagiaire.setDateDeNaissance(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                    stagiaire.setVilleDeNaissance(faker.address().city());
                    stagiaire.setCivilite(Civilite.values()[faker.number().numberBetween(0, Civilite.values().length)]);
                    stagiaire.setUnite(uniteService.findById((long) faker.number().numberBetween(1, 10)).orElse(null));
                }
            } catch (Exception e) {
                throw new ServiceException(e);
            }
        }
    }
}
