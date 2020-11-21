package ch.aaap.talks.micronaut.springmonolith;

import ch.aaap.talks.micronaut.VaccinationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.SimpleHttpInvokerRequestExecutor;

@SuppressWarnings("deprecation")
@Configuration
public class RemotingOutbound {

    @Value("${vaccination.service.remoting.base.url:http://localhost:50002}")
    private String vaccinationServiceRemotingBase;

    @Bean
    public HttpInvokerProxyFactoryBean createVaccinationServiceInvoker() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setHttpInvokerRequestExecutor(new SimpleHttpInvokerRequestExecutor());
        invoker.setServiceUrl(vaccinationServiceRemotingBase + VaccinationService.URI);
        invoker.setServiceInterface(VaccinationService.class);
        return invoker;
    }

}
