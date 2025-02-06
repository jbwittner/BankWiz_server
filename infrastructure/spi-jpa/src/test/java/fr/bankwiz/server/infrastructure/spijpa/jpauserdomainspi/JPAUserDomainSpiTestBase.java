package fr.bankwiz.server.infrastructure.spijpa.jpauserdomainspi;

import org.springframework.beans.factory.annotation.Autowired;

import fr.bankwiz.server.infrastructure.spijpa.SpiJpaApplicationTests;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.JPAUserDomainSpi;

class JPAUserDomainSpiTestBase extends SpiJpaApplicationTests {

    @Autowired
    protected JPAUserDomainSpi jpaUserDomainSpi;
}
