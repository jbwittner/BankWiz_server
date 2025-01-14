package fr.bankwiz.server.domain.api;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;

import java.util.List;

public interface CurrencyDomainApi {
    List<CurrencyDomain> getCurrencies();
}
