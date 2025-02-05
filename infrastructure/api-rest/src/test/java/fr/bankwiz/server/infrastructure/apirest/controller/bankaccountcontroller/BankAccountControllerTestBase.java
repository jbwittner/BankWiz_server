package fr.bankwiz.server.infrastructure.apirest.controller.bankaccountcontroller;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import fr.bankwiz.server.infrastructure.apirest.ApiRestTestsBase;
import fr.bankwiz.server.infrastructure.apirest.controller.Endpoints;
import fr.bankwiz.server.infrastructure.apirest.controller.data.mapper.RestBankAccountMapper;

@DisplayName("Bank account Controller Test Base")
class BankAccountControllerTestBase extends ApiRestTestsBase {

    protected final String baseUrl = "/" + Endpoints.BankAccount.BASE;

    @Autowired
    protected RestBankAccountMapper restBankAccountMapper;
}
