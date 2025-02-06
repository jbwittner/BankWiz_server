package fr.bankwiz.server.infrastructure.spijpa.jpabankaccountdomainspi;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.instancio.Select;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.domain.model.data.UserDomain;

class SaveTest extends JPABankAccountDomainSpiTestBase {

    @Test
    @Sql(
            scripts = {"/sql/jpacurrencydomainspi/save/data.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void save() {
        // Given
        final CurrencyDomain currencyDomain =
                this.jPACurrencyDomainSpi.findByIsoCode("USD").orElseThrow();
        final UserDomain userDomain =
                this.jPAUserDomainSpi.findByAuthId("authtata").orElseThrow();
        final BankAccountDomain bankAccountDomain = Instancio.of(BankAccountDomain.class)
                .set(Select.field(BankAccountDomain::currency), currencyDomain)
                .set(Select.field(BankAccountDomain::user), userDomain)
                .create();

        // When
        Optional<BankAccountDomain> optional = this.jPABankAccountDomainSpi.findById(bankAccountDomain.id());
        Assertions.assertThat(optional).isEmpty();

        final BankAccountDomain bankAccountDomainSaved = this.jPABankAccountDomainSpi.save(bankAccountDomain);

        // Then
        optional = this.jPABankAccountDomainSpi.findById(bankAccountDomain.id());
        Assertions.assertThat(optional).isPresent().contains(bankAccountDomain).contains(bankAccountDomainSaved);
    }
}
