package fr.bankwiz.server.infrastructure.spijpa.spi.database.mapper;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.CurrencyEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JPACurrencyMapper {
    CurrencyDomain toCurrencyDomain(CurrencyEntity entity);
    CurrencyEntity toCurrencyEntity(CurrencyDomain domain);
    List<CurrencyDomain> toCurrencyDomain(List<CurrencyEntity> entities);
    List<CurrencyEntity> toCurrencyEntity(List<CurrencyDomain> domain);
}
