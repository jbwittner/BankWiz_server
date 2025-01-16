package fr.bankwiz.server.infrastructure.apirest.controller.data.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BankAccountDTO(
        @NotNull UUID id,
        @JsonProperty("account_name") @NotBlank String accountName,
        @NotNull CurrencyDTO currency,
        @JsonProperty("initial_decimal_balance") @NotNull Integer initialDecimalBalance,
        @NotNull UserDTO user) {}
