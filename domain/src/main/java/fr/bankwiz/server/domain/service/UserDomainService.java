package fr.bankwiz.server.domain.service;

import fr.bankwiz.server.domain.annotation.DomainService;
import fr.bankwiz.server.domain.api.UserDomainApi;
import fr.bankwiz.server.domain.model.data.UserAuthenticationDomain;
import fr.bankwiz.server.domain.model.data.UserDomain;
import fr.bankwiz.server.domain.spi.AuthenticationSpi;
import fr.bankwiz.server.domain.spi.UserDomainSpi;
import fr.bankwiz.server.domain.tools.UUIDGenerator;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class UserDomainService implements UserDomainApi {

    private final AuthenticationSpi authenticationSpi;
    private final UserDomainSpi userDomainSpi;

    @Override
    public UserDomain authenticationUser() {
        final UserAuthenticationDomain userAuthentication = authenticationSpi.getCurrentUserAuthentication();
        final var optionalUserDomain = userDomainSpi.findByAuthId(userAuthentication.sub());

        final UserDomain.UserDomainBuilder userDomainBuilder = UserDomain.builder();

        if (optionalUserDomain.isPresent()) {
            final UserDomain userDomainFound = optionalUserDomain.get();
            userDomainBuilder.id(userDomainFound.id());
        } else {
            userDomainBuilder.id(UUIDGenerator.generateUUID());
        }

        final UserDomain userDomain = userDomainBuilder
                .authId(userAuthentication.sub())
                .email(userAuthentication.email())
                .fullName(userAuthentication.fullName())
                .nickName(userAuthentication.nickname())
                .build();

        return userDomainSpi.save(userDomain);
    }
}
