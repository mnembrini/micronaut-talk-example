package ch.aaap.talks.micronaut;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.annotation.Value;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.SimpleHttpInvokerRequestExecutor;

@SuppressWarnings("deprecation")
@Factory
public class RemotingOutbound {

    @Value("${language.service.remoting.base.url:http://localhost:50002}")
    private String languageServiceRemotingBase;

    @Bean
    @Requires(notEnv = "test") // workaround mockbean
    public LanguageService createLanguageServiceInvoker() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setHttpInvokerRequestExecutor(new SimpleHttpInvokerRequestExecutor());
        invoker.setServiceUrl(languageServiceRemotingBase + LanguageService.URI);
        invoker.setServiceInterface(LanguageService.class);
        invoker.afterPropertiesSet();
        return (LanguageService) invoker.getObject();
    }

}
