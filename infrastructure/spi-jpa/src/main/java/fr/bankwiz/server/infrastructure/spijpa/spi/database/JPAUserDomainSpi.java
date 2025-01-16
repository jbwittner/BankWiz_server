package fr.bankwiz.server.infrastructure.spijpa.spi.database;

import java.util.Optional;
import java.util.UUID;

import fr.bankwiz.server.infrastructure.spijpa.spi.database.mapper.JPAUserMapper;
import org.springframework.stereotype.Component;

import fr.bankwiz.server.domain.model.data.UserDomain;
import fr.bankwiz.server.domain.spi.UserDomainSpi;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.UserEntity;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JPAUserDomainSpi implements UserDomainSpi {

    private final UserEntityRepository userEntityRepository;
    private final JPAUserMapper jpaUserMapper;

    @Override
    public Optional<UserDomain> findByAuthId(final String authId) {
        final var optional = userEntityRepository.findByAuthId(authId);

        if (optional.isPresent()) {
            final UserDomain userDomain = jpaUserMapper.toUserDomain(optional.get());
            return Optional.of(userDomain);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public UserDomain save(final UserDomain userDomain) {
        final UserEntity userEntity = jpaUserMapper.toUserEntity(userDomain);
        final UserEntity savedUserEntity = userEntityRepository.save(userEntity);
        return jpaUserMapper.toUserDomain(savedUserEntity);
    }

    @Override
    public Optional<UserDomain> findById(final UUID id) {
        final var optional = userEntityRepository.findById(id);

        if (optional.isPresent()) {
            final UserDomain userDomain = jpaUserMapper.toUserDomain(optional.get());
            return Optional.of(userDomain);
        } else {
            return Optional.empty();
        }
    }
}
