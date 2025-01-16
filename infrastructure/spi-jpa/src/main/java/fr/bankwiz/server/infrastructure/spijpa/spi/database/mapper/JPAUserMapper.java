package fr.bankwiz.server.infrastructure.spijpa.spi.database.mapper;

import org.mapstruct.Mapper;

import fr.bankwiz.server.domain.model.data.UserDomain;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface JPAUserMapper {
    UserEntity toUserEntity(UserDomain userDomain);
    UserDomain toUserDomain(UserEntity userEntity);
}
