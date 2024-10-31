package fr.bankwiz.server.infrastructure.spijpa.jpauserdomainspi;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import fr.bankwiz.server.infrastructure.spijpa.SpiJpaApplicationTests;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.JPAUserDomainSpi;

@DisplayName("JPA User Domain SPI Layer Test")
class JPAUserDomainSpiTestBase extends SpiJpaApplicationTests {

    @Autowired
    protected JPAUserDomainSpi jpaUserDomainSpi;
}
