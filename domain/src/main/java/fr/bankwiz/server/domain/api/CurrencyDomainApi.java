package fr.bankwiz.server.domain.api;

import java.util.List;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;

public interface CurrencyDomainApi {
    List<CurrencyDomain> getCurrencies();
}
