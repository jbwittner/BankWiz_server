package fr.bankwiz.server.domain.spi;

import fr.bankwiz.server.domain.model.data.UserAuthenticationDomain;
import fr.bankwiz.server.domain.model.data.UserDomain;

public interface AuthenticationSpi {
    UserAuthenticationDomain getCurrentUserAuthentication();

    UserDomain getCurrentUser();
}
