package fr.bankwiz.server.domain.mockhelper;

import org.mockito.Mockito;

import fr.bankwiz.server.domain.model.data.UserAuthenticationDomain;
import fr.bankwiz.server.domain.spi.AuthenticationSpi;

public class MockAuthenticationSpi extends MockHelper<AuthenticationSpi> {

    public MockAuthenticationSpi() {
        super(AuthenticationSpi.class);
    }

    public void mockGetCurrentUserAuthentication(final UserAuthenticationDomain userAuthenticationDomain) {
        Mockito.when(mock.getCurrentUserAuthentication()).thenReturn(userAuthenticationDomain);
    }
}
