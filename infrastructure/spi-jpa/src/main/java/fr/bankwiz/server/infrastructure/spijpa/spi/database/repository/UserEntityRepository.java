package fr.bankwiz.server.infrastructure.spijpa.spi.database.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByAuthId(String authId);
}
