package ch.aaap.talks.micronaut.client;

import ch.aaap.talks.micronaut.InventoryOperations;
import io.micronaut.http.client.annotation.Client;

@Client(id = "inventory", path = InventoryOperations.URI)
public interface InventoryClient extends InventoryOperations {
}
