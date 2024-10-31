package fr.bankwiz.server.infrastructure.spijpa.jpauserdomainspi;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import fr.bankwiz.server.domain.model.data.UserDomain;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Find By Id Test")
class FindByIdTest extends JPAUserDomainSpiTestBase {

    final UUID uuid = UUID.fromString("0192e236-f6d3-7528-9791-145f4cd38abe");

    @Test
    @DisplayName("User not exist")
    void user_not_exist() {
        // 👉 When
        final var optional = jpaUserDomainSpi.findById(uuid);

        // ✅ Then
        assertThat(optional.isPresent()).isFalse();
    }

    @Test
    @DisplayName("User exist")
    @Sql(
            scripts = {"/sql/jpauserdomainspi/findbyid/userexist.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void user_exist() {
        // 👉 When
        final var optional = jpaUserDomainSpi.findById(uuid);

        // ✅ Then
        assertThat(optional.isPresent()).isTrue();

        final UserDomain userDomain = optional.get();

        assertThat(userDomain.id()).isEqualTo(uuid);
        assertThat(userDomain.authId()).isEqualTo("authtata");
        assertThat(userDomain.email()).isEqualTo("tata@email.com");
        assertThat(userDomain.fullName()).isEqualTo("tata full name");
        assertThat(userDomain.nickName()).isEqualTo("nick name tata");
    }
}
