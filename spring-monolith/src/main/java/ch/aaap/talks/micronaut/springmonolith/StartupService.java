package ch.aaap.talks.micronaut.springmonolith;

import ch.aaap.talks.micronaut.PetType;
import ch.aaap.talks.micronaut.VaccinationService;
import ch.aaap.talks.micronaut.Vaccine;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupService implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartupService.class);

    private final VaccinationService vaccinationService;

    public StartupService(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Vaccine> catVaccines = vaccinationService.findVaccinesFor(PetType.CAT);
        log.info("We currently have these cat vaccines: {}", catVaccines);
    }
}
