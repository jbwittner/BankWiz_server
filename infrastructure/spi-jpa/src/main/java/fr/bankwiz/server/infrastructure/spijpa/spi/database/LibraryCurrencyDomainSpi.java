package fr.bankwiz.server.infrastructure.spijpa.spi.database;

import java.util.Optional;

import org.springframework.stereotype.Component;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.domain.spi.CurrencyDomainSpi;

@Component
public class LibraryCurrencyDomainSpi implements CurrencyDomainSpi {
    @Override
    public Optional<CurrencyDomain> findByIsoCode(String isoCode) {
        CurrencyDomain currencyDomain = new CurrencyDomain("EUR", "Euro", "€", 1000);
        return Optional.of(currencyDomain);
    }
}
