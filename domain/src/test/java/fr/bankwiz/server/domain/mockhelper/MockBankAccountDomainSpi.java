package fr.bankwiz.server.domain.mockhelper;

import java.util.UUID;

import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.domain.spi.BankAccountDomainSpi;

public class MockBankAccountDomainSpi extends MockBaseDomainSpiHelper<BankAccountDomainSpi, BankAccountDomain, UUID> {
    public MockBankAccountDomainSpi() {
        super(BankAccountDomainSpi.class);
    }
}
