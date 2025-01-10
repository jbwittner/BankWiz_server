package fr.bankwiz.server.domain.model.data;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UserDomain(@NotNull UUID id, @NotBlank String authId, @NotBlank String nickName, @NotBlank String email, @NotBlank String fullName) {}
