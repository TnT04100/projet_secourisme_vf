package net.ent.etnc.projet_secourisme_vf.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class GeneralConfig {
    @Bean
    public Faker faker() {
        return Faker.instance(Locale.FRANCE);
    }
}
