package fr.bankwiz.server.infrastructure.apirest.controller.data.mapper;

import org.mapstruct.Mapper;

import fr.bankwiz.server.domain.model.data.SimpleData;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.SimpleDTO;

@Mapper(componentModel = "spring")
public interface RestSimpleDataMapper {

    SimpleDTO toSimpleDTO(SimpleData simpleData);
}
