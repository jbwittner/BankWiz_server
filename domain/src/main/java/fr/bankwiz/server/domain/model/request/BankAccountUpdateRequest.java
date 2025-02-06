package fr.bankwiz.server.domain.model.request;

public record BankAccountUpdateRequest(String accountName, String isoCurrencyCode, Integer initialDecimalBalance) {}
