package fr.bankwiz.server.infrastructure.apirest.controller.data.mapper;

import org.mapstruct.Mapper;

import fr.bankwiz.server.domain.model.data.UserDomain;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface RestUserDomainMapper {

    UserDTO toDTO(UserDomain userDomain);
}
