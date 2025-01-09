package fr.bankwiz.server.domain.model.data;

import java.util.UUID;

import lombok.Builder;

@Builder
public record BankAccountDomain(UUID id, String accountName, CurrencyDomain currency, Integer initialDecimalBalance) {}
