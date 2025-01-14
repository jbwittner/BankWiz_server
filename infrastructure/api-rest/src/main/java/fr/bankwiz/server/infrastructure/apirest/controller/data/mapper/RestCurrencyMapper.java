package fr.bankwiz.server.infrastructure.apirest.controller.data.mapper;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.CurrencyDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestCurrencyMapper {
    CurrencyDTO toCurrencyDTO(CurrencyDomain currencyDomain);
    List<CurrencyDTO> toCurrencyDTOs(List<CurrencyDomain> currencyDomains);
}
