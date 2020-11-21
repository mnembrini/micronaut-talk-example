package ch.aaap.talks.micronaut;

import java.util.Locale;

public interface LanguageService {

    String URI = "/remoting/languageService";

    Locale getCurrentLanguage();
}
