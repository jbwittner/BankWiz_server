package fr.bankwiz.server.infrastructure.apirest.controller.currencycontroller;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import fr.bankwiz.server.infrastructure.apirest.ApiRestTestsBase;
import fr.bankwiz.server.infrastructure.apirest.controller.Endpoints;
import fr.bankwiz.server.infrastructure.apirest.controller.data.mapper.RestUserMapper;

@DisplayName("Currency Controller Test Base")
class CurrencyControllerTestBase extends ApiRestTestsBase {

    protected final String baseUrl = "/" + Endpoints.Currency.BASE + "/";

    @Autowired
    protected RestUserMapper restUserMapper;
}
