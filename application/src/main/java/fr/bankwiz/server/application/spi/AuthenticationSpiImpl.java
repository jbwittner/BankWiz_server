package fr.bankwiz.server.application.spi;

import org.springframework.stereotype.Component;

import fr.bankwiz.server.domain.model.data.UserAuthenticationDomain;
import fr.bankwiz.server.domain.model.data.UserDomain;
import fr.bankwiz.server.domain.spi.AuthenticationSpi;
import fr.bankwiz.server.domain.spi.UserDomainSpi;
import fr.bankwiz.server.infrastructure.apirest.spi.Oauth2AuthenticationSpi;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AuthenticationSpiImpl implements AuthenticationSpi {

    final Oauth2AuthenticationSpi oauth2AuthenticationSpi;
    final UserDomainSpi userDomainSpi;

    @Override
    public UserAuthenticationDomain getCurrentUserAuthentication() {
        return oauth2AuthenticationSpi.getCurrentUserAuthentication();
    }

    @Override
    public UserDomain getCurrentUser() {
        final UserAuthenticationDomain userAuthenticationDomain = getCurrentUserAuthentication();
        return userDomainSpi.findByAuthId(userAuthenticationDomain.sub()).orElseThrow();
    }
}
