package fr.bankwiz.server.domain.service.userservice;

import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.bankwiz.server.domain.model.data.UserDomain;

class FindAllTest extends UserDomainServiceTestBase {

    @Test
    @DisplayName("Should return all users")
    void should_return_all_users() {
        // Given
        final var expectedUsers = Instancio.createList(UserDomain.class);
        this.mockUserDomainSpi.mockFindAll(expectedUsers);

        // When
        final var users = userDomainService.findAll();
        // Then

        Assertions.assertThat(users).containsExactlyInAnyOrderElementsOf(expectedUsers);
    }
}
