package fr.bankwiz.server.infrastructure.spijpa.spi.database.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import fr.bankwiz.server.domain.model.data.UserDomain;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface JPAUserMapper {
    UserEntity toUserEntity(UserDomain userDomain);

    UserDomain toUserDomain(UserEntity userEntity);

    List<UserDomain> toUserDomain(List<UserEntity> userEntities);
}
