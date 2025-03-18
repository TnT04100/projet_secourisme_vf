package net.ent.etnc.projet_secourisme_vf.init;

import com.github.javafaker.Faker;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.ent.etnc.projet_secourisme_vf.service.CelluleSecourismeService;
import net.ent.etnc.projet_secourisme_vf.service.FormateurService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
@Order(-1)
public class InitGlobal implements CommandLineRunner {
    // Initialise moi toutes les classes s'il te plait avec faker

    @NonNull
    private final FormateurService formateurService;

    @NonNull
    private final CelluleSecourismeService celluleSecourismeService;

    @NonNull
    Faker faker = Faker.instance(Locale.FRANCE);

    @Override
    public void run(String... args) throws Exception {
        // TODO document why this method is empty
    }
}
