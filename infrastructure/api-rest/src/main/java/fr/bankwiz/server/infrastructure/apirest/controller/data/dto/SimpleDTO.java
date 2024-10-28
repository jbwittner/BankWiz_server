package fr.bankwiz.server.infrastructure.apirest.controller.data.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SimpleDTO(@NotNull UUID id, @NotBlank String simpleData) {}
