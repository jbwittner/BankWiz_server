package fr.bankwiz.server.application.spi.currencydomainspiimpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindAllTest extends CurrencyDomainSpiImplTestBase{

    @Test
    void find_all(){
        final var result = this.currencyDomainSpi.findAll();

        Assertions.assertNotNull(result);
    }
}
