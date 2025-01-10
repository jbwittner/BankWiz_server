package fr.bankwiz.server.domain.exception;

import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;

public class ValidationException extends FunctionalException {
    public ValidationException(Set<? extends ConstraintViolation<?>> violations) {
        super("Validation errors occurred");

        // Map the violations to a map of property path -> message
        this.attributes.putAll(violations.stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString(), ConstraintViolation::getMessage)));
    }
}
