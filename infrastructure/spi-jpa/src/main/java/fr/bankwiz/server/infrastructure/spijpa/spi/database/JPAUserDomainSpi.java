package fr.bankwiz.server.infrastructure.spijpa.spi.database;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import fr.bankwiz.server.domain.model.data.UserDomain;
import fr.bankwiz.server.domain.spi.UserDomainSpi;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.UserEntity;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.mapper.JPAUserDomainMapper;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JPAUserDomainSpi implements UserDomainSpi {

    private final UserEntityRepository userEntityRepository;
    private final JPAUserDomainMapper jpaUserDomainMapper;

    @Override
    public Optional<UserDomain> findByAuthId(String authId) {
        final var optional = userEntityRepository.findByAuthId(authId);

        if (optional.isPresent()) {
            final UserDomain userDomain = jpaUserDomainMapper.toDomain(optional.get());
            return Optional.of(userDomain);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public UserDomain save(UserDomain userDomain) {
        final UserEntity userEntity = jpaUserDomainMapper.toEntity(userDomain);
        final UserEntity savedUserEntity = userEntityRepository.save(userEntity);
        return jpaUserDomainMapper.toDomain(savedUserEntity);
    }

    @Override
    public Optional<UserDomain> findById(UUID id) {
        final var optional = userEntityRepository.findById(id);

        if (optional.isPresent()) {
            final UserDomain userDomain = jpaUserDomainMapper.toDomain(optional.get());
            return Optional.of(userDomain);
        } else {
            return Optional.empty();
        }
    }
}
