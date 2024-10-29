package fr.bankwiz.server.domain.spi;

import fr.bankwiz.server.domain.model.data.UserAuthenticationDomain;

public interface AuthenticationSpi {

    UserAuthenticationDomain getCurrentUserAuthentication();
}
