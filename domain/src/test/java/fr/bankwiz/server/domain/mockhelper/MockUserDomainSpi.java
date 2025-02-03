package fr.bankwiz.server.domain.mockhelper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.mockito.Mockito;

import fr.bankwiz.server.domain.model.data.UserDomain;
import fr.bankwiz.server.domain.spi.UserDomainSpi;

public class MockUserDomainSpi extends MockBaseDomainSpiHelper<UserDomainSpi, UserDomain, UUID> {

    public MockUserDomainSpi() {
        super(UserDomainSpi.class);
    }

    public void mockFindByAuthId(final String authId, final Optional<UserDomain> optionalUserDomain) {
        Mockito.when(this.mock.findByAuthId(authId)).thenReturn(optionalUserDomain);
    }

    public void mockFindAll(final List<UserDomain> userDomains) {
        Mockito.when(this.mock.findAll()).thenReturn(userDomains);
    }

}
