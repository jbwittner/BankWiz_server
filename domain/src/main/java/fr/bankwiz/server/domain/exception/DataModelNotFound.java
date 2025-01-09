package fr.bankwiz.server.domain.exception;

public class DataModelNotFound extends FunctionalException {
    public DataModelNotFound(Class<?> clazz, Object searchValue) {
        super(clazz.getSimpleName() + " not found with value: " + searchValue);
    }
}
