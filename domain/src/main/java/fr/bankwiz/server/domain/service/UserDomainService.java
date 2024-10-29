package fr.bankwiz.server.domain.service;

import fr.bankwiz.server.domain.api.UserDomainApi;
import fr.bankwiz.server.domain.model.data.UserDomain;
import fr.bankwiz.server.domain.spi.AuthenticationSpi;
import fr.bankwiz.server.domain.spi.UserDomainSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDomainService implements UserDomainApi {

    private final AuthenticationSpi authenticationSpi;
    private final UserDomainSpi userDomainSpi;

    @Override
    public UserDomain authenticationUser() {
        return null;
    }
}
