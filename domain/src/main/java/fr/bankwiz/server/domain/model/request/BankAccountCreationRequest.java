package fr.bankwiz.server.domain.model.request;

public record BankAccountCreationRequest(String accountName, String isoCurrencyCode, Integer initialDecimalBalance) {}
