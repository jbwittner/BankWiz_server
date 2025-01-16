package fr.bankwiz.server.domain.spi;

import java.util.List;
import java.util.Optional;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;

public interface CurrencyDomainSpi {
    List<CurrencyDomain> findAll();
    Optional<CurrencyDomain> findByIsoCode(String isoCode);
}
