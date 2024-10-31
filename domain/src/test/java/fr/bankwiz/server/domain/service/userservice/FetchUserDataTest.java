package fr.bankwiz.server.domain.service.userservice;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.bankwiz.server.domain.FactoryHelper;
import fr.bankwiz.server.domain.model.data.UserAuthenticationDomain;
import fr.bankwiz.server.domain.model.data.UserDomain;

@DisplayName("Fetch User Data")
class FetchUserDataTest extends UserDomainServiceTestBase {

    @Test
    @DisplayName("User not exists")
    void user_not_exists() {
        // ⚙ Given that
        final UserAuthenticationDomain userAuthenticationDomain = Instancio.create(UserAuthenticationDomain.class);
        this.mockAuthenticationSpi.mockGetCurrentUserAuthentication(userAuthenticationDomain);
        this.mockUserDomainSpi.mockFindByAuthId(userAuthenticationDomain.sub(), Optional.empty());
        this.mockUserDomainSpi.mockSave();

        // 👉 When
        final UserDomain userDomain = this.userDomainService.authenticationUser();

        // ✅ Then
        Assertions.assertThat(userDomain).isNotNull();
        Assertions.assertThat(userDomain.authId()).isEqualTo(userAuthenticationDomain.sub());
        Assertions.assertThat(userDomain.fullName()).isEqualTo(userAuthenticationDomain.fullName());
        Assertions.assertThat(userDomain.nickName()).isEqualTo(userAuthenticationDomain.nickname());
        Assertions.assertThat(userDomain.email()).isEqualTo(userAuthenticationDomain.email());

        this.mockUserDomainSpi.verifySave(userDomain);
    }

    @Test
    @DisplayName("User already exists")
    void user_already_exists() {
        // ⚙ Given that
        final UserAuthenticationDomain userAuthenticationDomain = Instancio.create(UserAuthenticationDomain.class);
        this.mockAuthenticationSpi.mockGetCurrentUserAuthentication(userAuthenticationDomain);

        final UserDomain userDomain = FactoryHelper.createUserDomain();
        this.mockUserDomainSpi.mockFindByAuthId(userAuthenticationDomain.sub(), Optional.of(userDomain));

        this.mockUserDomainSpi.mockSave();

        // 👉 When
        final UserDomain userDomainResult = this.userDomainService.authenticationUser();

        // ✅ Then
        Assertions.assertThat(userDomainResult).isNotNull();
        Assertions.assertThat(userDomainResult.authId())
                .isEqualTo(userAuthenticationDomain.sub())
                .isNotEqualTo(userDomain.authId());
        Assertions.assertThat(userDomainResult.fullName())
                .isEqualTo(userAuthenticationDomain.fullName())
                .isNotEqualTo(userDomain.fullName());
        Assertions.assertThat(userDomainResult.nickName())
                .isEqualTo(userAuthenticationDomain.nickname())
                .isNotEqualTo(userDomain.nickName());
        Assertions.assertThat(userDomainResult.email())
                .isEqualTo(userAuthenticationDomain.email())
                .isNotEqualTo(userDomain.email());
    }
}
