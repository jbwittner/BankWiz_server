package fr.bankwiz.server.infrastructure.spijpa.spi.database.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "SIMPLE_ENTITY")
public class SimpleEntity {

    @Id
    @Column(name = "SIMPLE_DATA_ID", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "SIMPLE_DATA", nullable = false)
    private String simpleData;
}
