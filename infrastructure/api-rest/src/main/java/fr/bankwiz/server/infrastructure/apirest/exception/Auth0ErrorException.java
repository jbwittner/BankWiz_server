package fr.bankwiz.server.infrastructure.apirest.exception;

public class Auth0ErrorException extends RuntimeException {

    public Auth0ErrorException(final Throwable cause) {
        super(cause);
    }
}
