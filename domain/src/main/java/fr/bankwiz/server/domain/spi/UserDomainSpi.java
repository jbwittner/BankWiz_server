package fr.bankwiz.server.domain.spi;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import fr.bankwiz.server.domain.model.data.UserDomain;

public interface UserDomainSpi extends BaseDomainSpi<UserDomain, UUID> {
    List<UserDomain> findAll();

    Optional<UserDomain> findByAuthId(final String authId);
}
