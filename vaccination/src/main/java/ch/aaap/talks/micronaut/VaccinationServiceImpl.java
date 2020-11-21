package ch.aaap.talks.micronaut;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class VaccinationServiceImpl implements VaccinationService {

    private static final Logger log = LoggerFactory.getLogger(VaccinationServiceImpl.class);

    private final LanguageService languageService;

    public VaccinationServiceImpl(LanguageService languageService) {
        this.languageService = languageService;
    }

    @Override
    public List<Vaccine> findVaccinesFor(PetType petType) {
        log.info("FindVaccinesFor {}", petType);

        log.info("Loading current language");
        Locale currentLanguage = languageService.getCurrentLanguage();
        log.info("Current language is {}", currentLanguage);

        Vaccine catVaccine = new Vaccine("cat vaccine", PetType.CAT, 60);
        Vaccine earlyCatVaccine = new Vaccine("early cat vaccine", PetType.CAT, 10);
        Vaccine dogVaccine = new Vaccine("dog vaccine", PetType.DOG, 100);
        Vaccine snakeVaccine = new Vaccine("snake vaccine", PetType.SNAKE, 5);

        return List.of(catVaccine, earlyCatVaccine, dogVaccine, snakeVaccine)
                .stream()
                .filter(it -> it.getType() == petType)
                .collect(Collectors.toList());
    }
}
