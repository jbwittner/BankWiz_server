package fr.bankwiz.server.infrastructure.spijpa.spi.database;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.domain.spi.CurrencyDomainSpi;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JPACurrencyDomainSpi implements CurrencyDomainSpi {

    @Override
    public List<CurrencyDomain> findAll() {
        return List.of();
    }

    @Override
    public Optional<CurrencyDomain> findByIsoCode(String isoCode) {
        return Optional.empty();
    }
}
