package fr.bankwiz.server.infrastructure.spijpa.spi.database.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.CurrencyEntity;

@Mapper(componentModel = "spring")
public interface JPACurrencyMapper {
    CurrencyDomain toCurrencyDomain(CurrencyEntity entity);

    List<CurrencyDomain> toCurrencyDomain(List<CurrencyEntity> entities);
}
