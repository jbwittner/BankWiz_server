package fr.bankwiz.server.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.bankwiz.server.domain.api.SimpleApi;
import fr.bankwiz.server.domain.api.UserDomainApi;
import fr.bankwiz.server.domain.service.SimpleService;
import fr.bankwiz.server.domain.service.UserDomainService;
import fr.bankwiz.server.domain.spi.AuthenticationSpi;
import fr.bankwiz.server.domain.spi.SimpleSpi;
import fr.bankwiz.server.domain.spi.UserDomainSpi;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DomainConfiguration {

    private final SimpleSpi simpleSpi;
    private final UserDomainSpi userDomainSpi;
    private final AuthenticationSpi authenticationSpi;

    @Bean
    public SimpleApi simpleApi() {
        return new SimpleService(simpleSpi);
    }

    @Bean
    public UserDomainApi userDomainApi() {
        return new UserDomainService(authenticationSpi, userDomainSpi);
    }
}
