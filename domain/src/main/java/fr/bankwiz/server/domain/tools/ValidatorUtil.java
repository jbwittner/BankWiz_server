package fr.bankwiz.server.domain.tools;

import java.util.Set;

import fr.bankwiz.server.domain.exception.ValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ValidatorUtil {

    private static final Validator validator;

    static {
        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private ValidatorUtil() {
        // Avoid instantiation
    }

    public static <T> void validate(final T object) {
        final Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new ValidationException(violations);
        }
    }
}
