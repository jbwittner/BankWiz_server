package fr.bankwiz.server.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.bankwiz.server.domain.api.SimpleApi;
import fr.bankwiz.server.domain.service.SimpleService;
import fr.bankwiz.server.domain.spi.SimpleSpi;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DomainConfiguration {

    private final SimpleSpi simpleSpi;

    @Bean
    public SimpleApi simpleApi() {
        return new SimpleService(simpleSpi);
    }
}
