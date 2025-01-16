package fr.bankwiz.server.infrastructure.spijpa.spi.database.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.CurrencyEntity;

public interface CurrencyEntityRepository extends JpaRepository<CurrencyEntity, UUID> {
    Optional<CurrencyEntity> findByIsoCode(String isoCode);
}
