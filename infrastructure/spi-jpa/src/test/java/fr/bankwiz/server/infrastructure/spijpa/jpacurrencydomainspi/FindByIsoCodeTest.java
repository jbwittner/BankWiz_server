package fr.bankwiz.server.infrastructure.spijpa.jpacurrencydomainspi;

import java.util.Optional;
import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;

class FindByIsoCodeTest extends JPACurrencyDomainSpiTestBase {

    @Test
    @Sql(
            scripts = {"/sql/jpacurrencydomainspi/findbyisocode/currencyexiste.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void currency_existe() {
        // When
        final Optional<CurrencyDomain> optionalCurrencyDomain = this.jpaCurrencyDomainSpi.findByIsoCode("USD");

        // Then
        final CurrencyDomain currency =
                new CurrencyDomain(UUID.fromString("0194dbf8-8c9e-772c-9734-ec1c8a1916f0"), "USD", "US Dollar", "$", 2);

        Assertions.assertThat(optionalCurrencyDomain).isPresent().contains(currency);
    }

    @Test
    void currency_not_existe() {
        // When
        final Optional<CurrencyDomain> optionalCurrencyDomain = this.jpaCurrencyDomainSpi.findByIsoCode("USD");

        // Then
        Assertions.assertThat(optionalCurrencyDomain).isEmpty();
    }
}
