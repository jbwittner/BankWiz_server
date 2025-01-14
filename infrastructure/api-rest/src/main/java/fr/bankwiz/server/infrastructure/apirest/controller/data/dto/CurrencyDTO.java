package fr.bankwiz.server.infrastructure.apirest.controller.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CurrencyDTO(
        @NotBlank String isoCode,
        @NotBlank String name,
        @NotBlank String symbol,
        @NotNull int decimalDigits
) {
}
