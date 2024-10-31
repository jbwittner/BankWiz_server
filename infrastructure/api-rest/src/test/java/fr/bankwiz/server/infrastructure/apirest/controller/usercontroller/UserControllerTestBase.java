package fr.bankwiz.server.infrastructure.apirest.controller.usercontroller;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import fr.bankwiz.server.infrastructure.apirest.ApiRestTestsBase;
import fr.bankwiz.server.infrastructure.apirest.controller.Endpoints;
import fr.bankwiz.server.infrastructure.apirest.controller.data.mapper.RestUserDomainMapper;

@DisplayName("User Controller Test Base")
class UserControllerTestBase extends ApiRestTestsBase {

    protected final String base_url = "/" + Endpoints.User.BASE + "/";

    @Autowired
    protected RestUserDomainMapper restUserDomainMapper;
}
