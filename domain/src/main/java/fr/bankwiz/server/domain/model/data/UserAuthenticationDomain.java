package fr.bankwiz.server.domain.model.data;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UserAuthenticationDomain(
        @NotBlank String sub, @NotBlank String email, @NotBlank String fullName, @NotBlank String nickname) {}
