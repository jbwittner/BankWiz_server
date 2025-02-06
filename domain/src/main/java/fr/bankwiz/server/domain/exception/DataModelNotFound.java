package fr.bankwiz.server.domain.exception;

public class DataModelNotFound extends FunctionalException {
    public DataModelNotFound(final Class<?> clazz, final Object searchValue) {
        super(clazz.getSimpleName() + " not found with value: " + searchValue);
    }
}
