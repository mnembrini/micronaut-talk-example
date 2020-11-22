package ch.aaap.talks.micronaut;

import ch.aaap.talks.micronaut.client.InventoryClient;
import java.time.LocalDate;
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
    private final InventoryClient inventoryClient;

    public VaccinationServiceImpl(LanguageService languageService, InventoryClient inventoryClient) {
        this.languageService = languageService;
        this.inventoryClient = inventoryClient;
    }

    @Override
    public List<Vaccine> findVaccinesFor(PetType petType) {
        log.info("FindVaccinesFor {}", petType);

        log.info("Loading current language");
        Locale currentLanguage = languageService.getCurrentLanguage();
        log.info("Current language is {}", currentLanguage);

        int availableStorage = inventoryClient.getAvailableStorage(LocalDate.now());
        log.info("Current available storage is {}", availableStorage);

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
