package ch.aaap.talks.micronaut;

import java.util.Locale;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class DummyLanguageService implements LanguageService {

    private static final Logger log = LoggerFactory.getLogger(DummyLanguageService.class);

    @Override
    public Locale getCurrentLanguage() {
        throw new RuntimeException("Please mock this method");
    }
}
