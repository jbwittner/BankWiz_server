package fr.bankwiz.server.infrastructure.spijpa.jpacurrencydomainspi;

import org.springframework.beans.factory.annotation.Autowired;

import fr.bankwiz.server.infrastructure.spijpa.SpiJpaApplicationTests;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.JPACurrencyDomainSpi;

class JPACurrencyDomainSpiTestBase extends SpiJpaApplicationTests {

    @Autowired
    protected JPACurrencyDomainSpi jpaCurrencyDomainSpi;
}
