package fr.bankwiz.server.infrastructure.apirest.controller.usercontroller;

import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import fr.bankwiz.server.domain.model.data.UserDomain;
import fr.bankwiz.server.infrastructure.apirest.controller.Endpoints;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.UserDTO;

@DisplayName("Authentication User Test")
class AuthenticationUserTest extends UserControllerTestBase {

    final String url = this.baseUrl + Endpoints.User.AUTHENTICATE;

    @Test
    @DisplayName("User not authenticated")
    void user_not_authenticated() {
        // 👉 When
        final var resultCall = this.apiTestHelper.getRequestWithoutAuthentication(url);

        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    @DisplayName("User authenticated")
    void user_authenticated() {
        // ⚙ Given that
        final UserDomain userDomain = Instancio.create(UserDomain.class);
        Mockito.when(this.userDomainApi.authenticationUser()).thenReturn(userDomain);

        // 👉 When
        final var resultCall = this.apiTestHelper.getRequest(url, UserDTO.class);

        // ✅ Then
        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.OK);

        final UserDTO expectedUserDTO = this.restUserDomainMapper.toDTO(userDomain);
        Assertions.assertThat(resultCall.result()).isEqualTo(expectedUserDTO);
    }
}
