package fr.bankwiz.server.domain.model.request;

public record BankAccountCreationRequest(String accountName, String iso3CurrencyCode, Integer initialDecimalBalance) {}
