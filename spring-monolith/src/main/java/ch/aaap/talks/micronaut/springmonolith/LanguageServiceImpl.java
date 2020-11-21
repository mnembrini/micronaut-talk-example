package ch.aaap.talks.micronaut.springmonolith;

import ch.aaap.talks.micronaut.LanguageService;
import java.util.Locale;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Override
    public Locale getCurrentLanguage() {
        return Locale.GERMAN;
    }
}
