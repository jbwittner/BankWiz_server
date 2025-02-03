package fr.bankwiz.server.domain.service.bankaccountservice;

import java.util.Optional;

import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.bankwiz.server.domain.FactoryHelper;
import fr.bankwiz.server.domain.exception.DataModelNotFound;
import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.domain.model.data.UserDomain;
import fr.bankwiz.server.domain.model.request.BankAccountCreationRequest;

import static org.instancio.Select.field;

public class CreateBankAccountTest extends BankAccountDomainServiceTestBase {

    @Test
    @DisplayName("Create a bank account")
    public void ok() {
        // Given
        final CurrencyDomain currency = FactoryHelper.createCurrencyDomain();
        final BankAccountCreationRequest request = Instancio.of(BankAccountCreationRequest.class)
                .set(field(BankAccountCreationRequest::isoCurrencyCode), currency.isoCode())
                .create();
        final UserDomain user = FactoryHelper.createUserDomain();

        this.mockCurrencyDomainSpi.mockFindByIsoCode(currency.isoCode(), Optional.of(currency));
        this.mockAuthenticationSpi.mockGetCurrentUser(user);
        this.mockBankAccountDomainSpi.mockSave();

        // When
        final BankAccountDomain result = this.bankAccountDomainService.createBankAccount(request);

        // Then
        this.mockBankAccountDomainSpi.verifySave(result);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(result),
                () -> Assertions.assertEquals(
                        request.isoCurrencyCode(), result.currency().isoCode()),
                () -> Assertions.assertEquals(request.accountName(), result.accountName()),
                () -> Assertions.assertEquals(request.initialDecimalBalance(), result.initialDecimalBalance()));
    }

    @Test
    @DisplayName("Currency not found")
    public void currencyNotFound() {
        // Given
        final BankAccountCreationRequest request = Instancio.create(BankAccountCreationRequest.class);

        // When
        final var exception = Assertions.assertThrows(
                DataModelNotFound.class, () -> this.bankAccountDomainService.createBankAccount(request));

        // Then
        this.mockBankAccountDomainSpi.verifySaveNotCalled();

        final String expectedMessage = "CurrencyDomain not found with value: " + request.isoCurrencyCode();
        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }
}
