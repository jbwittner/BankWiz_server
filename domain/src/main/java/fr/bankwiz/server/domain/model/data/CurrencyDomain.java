package fr.bankwiz.server.domain.model.data;

public record CurrencyDomain(String iso3Code, String name, String symbol, int decimalDigits) {}
