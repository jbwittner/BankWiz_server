package fr.bankwiz.server.infrastructure.apirest.controller.usercontroller;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.type.TypeReference;

import fr.bankwiz.server.domain.model.data.UserDomain;
import fr.bankwiz.server.infrastructure.apirest.controller.Endpoints;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.UserDTO;
import fr.bankwiz.server.infrastructure.apirest.controller.data.mapper.RestUserMapper;

class FindAllUsersTest extends UserControllerTestBase {

    final String url = super.baseUrl + Endpoints.User.FIND_ALL;

    @Autowired
    private RestUserMapper restUserMapper;

    @Test
    @DisplayName("User not authenticated")
    void user_not_authenticated() {
        // 👉 When
        final var resultCall = this.apiTestHelper.getRequestWithoutAuthentication(url);

        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    @DisplayName("User not authorized")
    void user_not_authorized() {
        // When
        final var resultCall = this.apiTestHelper.getRequest(url);

        // Then
        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.FORBIDDEN);
    }

    @Test
    void findAllUsersTest() {
        // Given
        final List<UserDomain> users = Instancio.createList(UserDomain.class);
        Mockito.when(this.userDomainApi.findAll()).thenReturn(users);

        // When
        final var resultCall =
                this.apiTestHelper.getRequest(url, new TypeReference<List<UserDTO>>() {}, "SCOPE_admin:configuration");

        // Then
        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.OK);
        final var usersDTOExpected = restUserMapper.toUserDTO(users);
        Assertions.assertThat(resultCall.result()).containsExactlyInAnyOrderElementsOf(usersDTOExpected);
    }
}
