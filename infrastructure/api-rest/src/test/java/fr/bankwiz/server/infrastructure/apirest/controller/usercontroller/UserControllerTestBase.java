package fr.bankwiz.server.infrastructure.apirest.controller.usercontroller;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

import fr.bankwiz.server.infrastructure.apirest.ApiRestTestsBase;
import fr.bankwiz.server.infrastructure.apirest.controller.Endpoints;
import fr.bankwiz.server.infrastructure.apirest.controller.data.mapper.RestUserMapper;

@DisplayName("User Controller Test Base")
class UserControllerTestBase extends ApiRestTestsBase {

    protected final String baseUrl = "/" + Endpoints.User.BASE + "/";

    @Autowired
    protected RestUserMapper restUserMapper;
}
