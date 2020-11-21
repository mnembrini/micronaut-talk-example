package ch.aaap.talks.micronaut;

import java.util.List;

public interface VaccinationService {

    String URI = "/remoting/vaccinationService";

    List<Vaccine> findVaccinesFor(PetType petType);
}
