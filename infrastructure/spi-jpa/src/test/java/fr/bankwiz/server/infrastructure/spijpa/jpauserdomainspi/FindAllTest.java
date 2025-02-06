package fr.bankwiz.server.infrastructure.spijpa.jpauserdomainspi;

import java.util.List;
import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import fr.bankwiz.server.domain.model.data.UserDomain;

class FindAllTest extends JPAUserDomainSpiTestBase {

    @Test
    @DisplayName("User exist")
    @Sql(
            scripts = {"/sql/jpauserdomainspi/findall/users.sql"},
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void find_all_users() {
        // When
        List<UserDomain> users = jpaUserDomainSpi.findAll();
        // Then
        final UserDomain user1 = new UserDomain(
                UUID.fromString("0194dbda-e37a-71ea-9d78-d38514379951"),
                "authtoto1",
                "nick name toto 1",
                "toto1@email.com",
                "toto full name 1");

        final UserDomain user2 = new UserDomain(
                UUID.fromString("0194dbdb-10e2-7262-8bde-d8c066fd8a12"),
                "authtoto2",
                "nick name toto 2",
                "toto2@email.com",
                "toto full name 2");

        final UserDomain user3 = new UserDomain(
                UUID.fromString("0194dbdb-341a-7e8d-bf4e-2541d5e1015a"),
                "authtoto3",
                "nick name toto 3",
                "toto3@email.com",
                "toto full name 3");

        final UserDomain user4 = new UserDomain(
                UUID.fromString("0194dbdb-4b7b-7b21-9e75-f8c125982288"),
                "authtoto4",
                "nick name toto 4",
                "toto4@email.com",
                "toto full name 4");

        Assertions.assertThat(users).contains(user1, user2, user3, user4).hasSize(4);
    }
}
