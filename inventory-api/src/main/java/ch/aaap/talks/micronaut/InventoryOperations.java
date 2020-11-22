package ch.aaap.talks.micronaut;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

@Validated
public interface InventoryOperations {

    String URI = "/inventory";

    @Post
    int getAvailableStorage(@Body @NotNull LocalDate at);
}
