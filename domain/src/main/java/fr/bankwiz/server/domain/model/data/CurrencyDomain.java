package fr.bankwiz.server.domain.model.data;

public record CurrencyDomain(String isoCode, String name, String symbol, int decimalDigits) {}
