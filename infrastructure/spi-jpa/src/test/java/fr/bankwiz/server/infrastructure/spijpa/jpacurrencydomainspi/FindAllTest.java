package fr.bankwiz.server.infrastructure.spijpa.jpacurrencydomainspi;

import java.util.List;
import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;

class FindAllTest extends JPACurrencyDomainSpiTestBase {

    @Test
    @Sql(
            scripts = {"/sql/jpacurrencydomainspi/findall/currencies.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void find_all() {
        // When
        final List<CurrencyDomain> currencies = jpaCurrencyDomainSpi.findAll();

        // Then
        final CurrencyDomain currency1 =
                new CurrencyDomain(UUID.fromString("0194dbf8-8c9e-772c-9734-ec1c8a1916f0"), "USD", "US Dollar", "$", 2);

        final CurrencyDomain currency2 =
                new CurrencyDomain(UUID.fromString("0194dbf8-bde4-7d17-b126-d5349a099a38"), "EUR", "Euro", "€", 2);

        final CurrencyDomain currency3 = new CurrencyDomain(
                UUID.fromString("0194dbf9-1160-7d09-af6e-5801770b2699"), "HKD", "HK Dollar", "HK$", 2);

        final CurrencyDomain currency4 =
                new CurrencyDomain(UUID.fromString("0194dc00-3e81-7a86-a7a8-74a9a4b0bdae"), "JPY", "YEN", "¥", 0);
        Assertions.assertThat(currencies)
                .contains(currency1, currency2, currency3, currency4)
                .hasSize(4);
    }
}
