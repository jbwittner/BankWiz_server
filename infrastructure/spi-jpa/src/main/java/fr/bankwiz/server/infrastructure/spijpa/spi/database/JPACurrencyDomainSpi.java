package fr.bankwiz.server.infrastructure.spijpa.spi.database;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.domain.spi.CurrencyDomainSpi;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.CurrencyEntity;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.mapper.JPACurrencyMapper;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.repository.CurrencyEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JPACurrencyDomainSpi implements CurrencyDomainSpi {

    private final CurrencyEntityRepository currencyEntityRepository;
    private final JPACurrencyMapper jpaCurrencyMapper;

    @Override
    public List<CurrencyDomain> findAll() {
        final List<CurrencyEntity> currencyEntityList = this.currencyEntityRepository.findAll();
        return jpaCurrencyMapper.toCurrencyDomain(currencyEntityList);
    }

    @Override
    public Optional<CurrencyDomain> findByIsoCode(String isoCode) {
        return this.currencyEntityRepository.findByCode(isoCode).map(jpaCurrencyMapper::toCurrencyDomain);
    }
}
