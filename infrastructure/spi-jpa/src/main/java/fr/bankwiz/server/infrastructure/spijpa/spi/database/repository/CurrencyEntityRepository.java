package fr.bankwiz.server.infrastructure.spijpa.spi.database.repository;

import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CurrencyEntityRepository extends JpaRepository<CurrencyEntity, UUID> {
    Optional<CurrencyEntity> findByCode(String code);
}
