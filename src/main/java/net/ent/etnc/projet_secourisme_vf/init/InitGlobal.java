package net.ent.etnc.projet_secourisme_vf.init;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ent.etnc.projet_secourisme_vf.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(-1)
public class InitGlobal implements CommandLineRunner {

    @NonNull
    private final FormateurService formateurService;

    @NonNull
    private final CelluleSecourismeService celluleSecourismeService;

    @NonNull
    private final StagiaireService stagiaireService;

    @NonNull
    private final LocalisationService localisationService;

    @NonNull
    private final UniteService uniteService;

    @NonNull
    private final UniteEnseignementService uniteEnseignementService;

    @Override
    public void run(String... args) throws Exception {
        try {
            uniteEnseignementService.init();
            localisationService.init();
            uniteService.init();
            stagiaireService.init();
            formateurService.init();
            celluleSecourismeService.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
