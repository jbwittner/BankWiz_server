package fr.bankwiz.server.infrastructure.spijpa.jpauserdomainspi;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import fr.bankwiz.server.domain.model.data.UserDomain;

import static org.assertj.core.api.Assertions.assertThat;

class SaveTest extends JPAUserDomainSpiTestBase {

    @Test
    void save() {
        // Given
        final var userDomain = Instancio.create(UserDomain.class);

        // When
        final var savedUserDomain = jpaUserDomainSpi.save(userDomain);

        // Then
        assertThat(savedUserDomain).isEqualTo(userDomain);
        final var optional = jpaUserDomainSpi.findById(savedUserDomain.id());
        assertThat(optional).isPresent();
        assertThat(optional.get()).isEqualTo(savedUserDomain);
    }
}
