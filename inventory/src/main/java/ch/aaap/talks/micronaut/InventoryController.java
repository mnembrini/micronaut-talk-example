package ch.aaap.talks.micronaut;

import io.micronaut.http.annotation.Controller;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller(InventoryOperations.URI)
public class InventoryController implements InventoryOperations {

    private static final Logger log = LoggerFactory.getLogger(InventoryController.class);

    @Override
    public int getAvailableStorage(@NotNull LocalDate at) {
        log.info("Checking current storage for day {}", at);
        return 150;
    }
}
