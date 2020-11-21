package ch.aaap.talks.micronaut.springmonolith;

import ch.aaap.talks.micronaut.LanguageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

@SuppressWarnings("deprecation")
@Configuration
public class RemotingInbound {

    @Bean(name = LanguageService.URI)
    HttpInvokerServiceExporter createLanguageServiceExporter(LanguageService service) {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(service);
        exporter.setServiceInterface(LanguageService.class);
        return exporter;
    }

}
