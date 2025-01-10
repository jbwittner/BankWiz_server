package fr.bankwiz.server.infrastructure.spijpa.spi.database;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.domain.spi.BankAccountDomainSpi;

@Component
public class JPABankAccountDomainSpi implements BankAccountDomainSpi {
    @Override
    public BankAccountDomain save(BankAccountDomain bankAccountDomain) {
        return null;
    }

    @Override
    public Optional<BankAccountDomain> findById(UUID id) {
        return Optional.empty();
    }
}
