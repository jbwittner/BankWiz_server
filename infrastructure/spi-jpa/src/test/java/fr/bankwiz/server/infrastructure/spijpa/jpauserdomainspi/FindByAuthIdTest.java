package fr.bankwiz.server.infrastructure.spijpa.jpauserdomainspi;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import fr.bankwiz.server.domain.model.data.UserDomain;

import static org.assertj.core.api.Assertions.assertThat;

class FindByAuthIdTest extends JPAUserDomainSpiTestBase {

    final String authId = "authtoto";

    @Test
    void user_not_exist() {
        // 👉 When
        final var optional = jpaUserDomainSpi.findByAuthId(authId);

        // ✅ Then
        assertThat(optional).isNotPresent();
    }

    @Test
    @Sql(
            scripts = {"/sql/jpauserdomainspi/findbyauthid/userexist.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void user_exist() {
        // ⚙ Given that
        final var optional = jpaUserDomainSpi.findByAuthId(authId);

        // 👉 When
        assertThat(optional).isPresent();

        // ✅ Then
        final UserDomain userDomain = optional.get();
        final UUID id = UUID.fromString("0192e249-09c5-7c42-a747-3b5e1979bb72");
        assertThat(userDomain.id()).isEqualTo(id);
        assertThat(userDomain.authId()).isEqualTo(authId);
        assertThat(userDomain.email()).isEqualTo("toto@email.com");
        assertThat(userDomain.fullName()).isEqualTo("toto full name");
        assertThat(userDomain.nickName()).isEqualTo("nick name toto");
    }
}
