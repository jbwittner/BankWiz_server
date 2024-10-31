package fr.bankwiz.server.domain.spi;

import java.util.Optional;
import java.util.UUID;

import fr.bankwiz.server.domain.model.data.UserDomain;

public interface UserDomainSpi extends BaseDomainSpi<UserDomain, UUID> {
    Optional<UserDomain> findByAuthId(final String authId);
}
