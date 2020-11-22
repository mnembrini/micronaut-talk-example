package ch.aaap.talks.micronaut

import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class VaccinationServiceImplSpec extends Specification {

  @Inject
  LanguageService languageService

  // we need to use an implementation class here, hence the Dummy
  @MockBean(DummyLanguageService)
  LanguageService languageService() {
    Mock(LanguageService)
  }


  void "Test mock remote interface"() {
    given:
    languageService.getCurrentLanguage() >> Locale.CANADA
    expect:
    languageService.getCurrentLanguage() == Locale.CANADA

  }
}
