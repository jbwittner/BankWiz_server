package fr.bankwiz.server.infrastructure.apirest.configuration;

import java.time.OffsetDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import fr.bankwiz.server.domain.exception.FunctionalException;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.FunctionalExceptionDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

    final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({FunctionalException.class})
    public ResponseEntity<Object> handleFunctionalException(final FunctionalException exception) {

        final FunctionalExceptionDTO functionalExceptionDTO = getFunctionalExceptionDTO(exception);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(functionalExceptionDTO);
    }

    private FunctionalExceptionDTO getFunctionalExceptionDTO(final FunctionalException exception) {
        final String exceptionName = exception.getClass().getSimpleName();
        final String exceptionMessage = exception.getMessage();

        logger.error("Exception : [{}] - {}", exceptionName, exceptionMessage);

        final FunctionalExceptionDTO functionalExceptionDTO = new FunctionalExceptionDTO(
                exceptionName, exception.getAttributes(), exceptionMessage, OffsetDateTime.now());

        this.logError(exceptionName, functionalExceptionDTO, exception);
        return functionalExceptionDTO;
    }

    private void logError(final String exceptionName, final Object exceptionDTO, final Throwable exception) {

        if (logger.isDebugEnabled()) {
            logger.debug("Exception details : [{}] - {}", exceptionName, exceptionDTO);

            if (logger.isTraceEnabled()) {
                logger.trace("Stack trace", exception);
            }
        }
    }
}
