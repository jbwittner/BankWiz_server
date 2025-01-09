package fr.bankwiz.server.domain.spi;

import java.util.Optional;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;

public interface CurrencyDomainSpi {
    Optional<CurrencyDomain> findByIsoCode(String isoCode);
}
