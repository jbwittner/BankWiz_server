package fr.bankwiz.server.infrastructure.spijpa.jpabankaccountdomainspi;

import org.springframework.beans.factory.annotation.Autowired;

import fr.bankwiz.server.infrastructure.spijpa.SpiJpaApplicationTests;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.JPABankAccountDomainSpi;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.JPACurrencyDomainSpi;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.JPAUserDomainSpi;

class JPABankAccountDomainSpiTestBase extends SpiJpaApplicationTests {

    @Autowired
    protected JPABankAccountDomainSpi jPABankAccountDomainSpi;

    @Autowired
    protected JPACurrencyDomainSpi jPACurrencyDomainSpi;

    @Autowired
    protected JPAUserDomainSpi jPAUserDomainSpi;
}
