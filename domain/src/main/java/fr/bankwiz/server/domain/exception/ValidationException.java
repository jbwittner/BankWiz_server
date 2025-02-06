package fr.bankwiz.server.domain.exception;

import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;

public class ValidationException extends FunctionalException {
    public ValidationException(final Set<? extends ConstraintViolation<?>> violations) {
        super("Validation errors occurred : " + violations);

        // Map the violations to a map of property path -> message
        this.attributes.putAll(violations.stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString(), ConstraintViolation::getMessage)));
    }
}
