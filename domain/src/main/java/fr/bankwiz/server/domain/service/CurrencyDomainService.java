package fr.bankwiz.server.domain.service;

import java.util.List;

import fr.bankwiz.server.domain.annotation.DomainService;
import fr.bankwiz.server.domain.api.CurrencyDomainApi;
import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.domain.spi.CurrencyDomainSpi;
import lombok.AllArgsConstructor;

@DomainService
@AllArgsConstructor
public class CurrencyDomainService implements CurrencyDomainApi {

    private final CurrencyDomainSpi currencyDomainSpi;

    @Override
    public List<CurrencyDomain> getCurrencies() {
        return this.currencyDomainSpi.findAll();
    }
}
