package fr.bankwiz.server.infrastructure.apirest.controller.data.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import fr.bankwiz.server.domain.model.data.UserDomain;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface RestUserMapper {

    UserDTO toUserDTO(UserDomain userDomain);

    List<UserDTO> toUserDTO(List<UserDomain> userDomains);
}
