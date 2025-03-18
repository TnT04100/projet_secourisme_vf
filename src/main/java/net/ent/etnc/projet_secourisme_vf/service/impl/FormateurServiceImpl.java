package net.ent.etnc.projet_secourisme_vf.service.impl;

import com.github.javafaker.Faker;
import net.ent.etnc.projet_secourisme_vf.models.Formateur;
import net.ent.etnc.projet_secourisme_vf.models.references.Civilite;
import net.ent.etnc.projet_secourisme_vf.repository.FormateurRepository;
import net.ent.etnc.projet_secourisme_vf.service.FormateurService;
import net.ent.etnc.projet_secourisme_vf.service.UniteService;
import net.ent.etnc.projet_secourisme_vf.service.base.AbstractService;
import net.ent.etnc.projet_secourisme_vf.service.exceptions.ServiceException;
import org.springframework.stereotype.Service;

import java.time.ZoneId;

@Service
public class FormateurServiceImpl extends AbstractService<Formateur, FormateurRepository, Long> implements FormateurService {

    private final UniteService uniteService;
    private final Faker faker;

    protected FormateurServiceImpl(FormateurRepository repository, Faker faker, UniteService uniteService) {
        super(repository);
        this.faker = faker;
        this.uniteService = uniteService;
    }

    @Override
    public void init() throws ServiceException {
        if (this.getRepository().count() == 0) {
            try {
                for (int i = 0; i < 100; i++) {
                    Formateur formateur = new Formateur();
                    formateur.setNumeroIdentifiantDefense(faker.regexify("[0-9]{10}"));
                    formateur.setNom(faker.name().lastName());
                    formateur.setPrenom(faker.name().firstName());
                    formateur.setDateDeNaissance(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                    formateur.setVilleDeNaissance(faker.address().city());
                    formateur.setCivilite(Civilite.values()[faker.number().numberBetween(0, Civilite.values().length)]);
                    formateur.setUnite(uniteService.findById((long) faker.number().numberBetween(1, 10)).orElse(null));
                }
            } catch (Exception e) {
                throw new ServiceException(e);
            }
        }
    }
}
