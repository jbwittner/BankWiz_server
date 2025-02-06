package fr.bankwiz.server.infrastructure.spijpa.jpauserdomainspi;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import fr.bankwiz.server.domain.model.data.UserDomain;

import static org.assertj.core.api.Assertions.assertThat;

class SaveTest extends JPAUserDomainSpiTestBase {

    @Test
    void save() {
        // ⚙ Given that
        final var userDomain = Instancio.create(UserDomain.class);

        // 👉 When
        var optional = jpaUserDomainSpi.findById(userDomain.id());
        assertThat(optional).isEmpty();

        final var savedUserDomain = jpaUserDomainSpi.save(userDomain);

        // ✅ Then
        optional = jpaUserDomainSpi.findById(userDomain.id());
        assertThat(optional).isPresent().contains(savedUserDomain).contains(userDomain);
    }
}
