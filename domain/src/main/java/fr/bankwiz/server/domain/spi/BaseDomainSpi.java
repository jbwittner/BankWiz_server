package fr.bankwiz.server.domain.spi;

import java.util.Optional;

public interface BaseDomainSpi<T, V> {
    T save(T t);

    Optional<T> findById(V id);
}
