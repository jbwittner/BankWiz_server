package fr.bankwiz.server.infrastructure.spijpa.jpauserdomainspi;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import fr.bankwiz.server.domain.model.data.UserDomain;

import static org.assertj.core.api.Assertions.assertThat;

class FindByIdTest extends JPAUserDomainSpiTestBase {

    final UUID uuid = UUID.fromString("0192e236-f6d3-7528-9791-145f4cd38abe");

    @Test
    void user_not_exist() {
        // 👉 When
        final var optional = jpaUserDomainSpi.findById(uuid);

        // ✅ Then
        assertThat(optional).isEmpty();
    }

    @Test
    @Sql(
            scripts = {"/sql/jpauserdomainspi/findbyid/userexist.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void user_exist() {
        // 👉 When
        final var optional = jpaUserDomainSpi.findById(uuid);

        // ✅ Then
        assertThat(optional).isPresent();

        final UserDomain userDomain = optional.get();

        assertThat(userDomain.id()).isEqualTo(uuid);
        assertThat(userDomain.authId()).isEqualTo("authtata");
        assertThat(userDomain.email()).isEqualTo("tata@email.com");
        assertThat(userDomain.fullName()).isEqualTo("tata full name");
        assertThat(userDomain.nickName()).isEqualTo("nick name tata");
    }
}
