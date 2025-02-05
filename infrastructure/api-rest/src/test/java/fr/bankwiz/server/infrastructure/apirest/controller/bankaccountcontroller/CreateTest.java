package fr.bankwiz.server.infrastructure.apirest.controller.bankaccountcontroller;

import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.BankAccountCreationRequestDTO;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.BankAccountDTO;

class CreateTest extends BankAccountControllerTestBase {

    private final String url = super.baseUrl;

    @Test
    @DisplayName("User not authenticated")
    void user_not_authenticated() {
        // 👉 When
        final var body = Instancio.create(BankAccountCreationRequestDTO.class);
        final var resultCall = this.apiTestHelper.postRequestWithoutAuthentication(url, body);

        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    @DisplayName("Create a bank account")
    void create_a_bank_account() {
        // 👉 Given
        final var body = Instancio.create(BankAccountCreationRequestDTO.class);
        Mockito.when(this.bankAccountDomainApi.createBankAccount(Mockito.any()))
                .thenReturn(Instancio.create(BankAccountDomain.class));

        // 👉 When
        final var resultCall = this.apiTestHelper.postRequest(url, body, BankAccountDTO.class);

        // 👉 Then
        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.CREATED);
    }
}
