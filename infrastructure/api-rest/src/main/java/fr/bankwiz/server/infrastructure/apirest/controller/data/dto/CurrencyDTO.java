package fr.bankwiz.server.infrastructure.apirest.controller.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CurrencyDTO(
        @JsonProperty("iso_code") @NotBlank String isoCode,
        @NotBlank String name,
        @NotBlank String symbol,
        @JsonProperty("decimal_digits") @NotNull int decimalDigits) {}
