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
@Table(name = "CURRENCIES")
public class CurrencyEntity {

    @Id
    @Column(name = "CURRENCY_ID", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "CURRENCY_NAME", nullable = false)
    private String name;

    @Column(name = "CURRENCY_CODE", nullable = false)
    private String code;

    @Column(name = "CURRENCY_SYMBOL", nullable = false)
    private String symbol;

    @Column(name = "CURRENCY_DECIMALS_DIGITS", nullable = false)
    private int decimalsDigits;
}
