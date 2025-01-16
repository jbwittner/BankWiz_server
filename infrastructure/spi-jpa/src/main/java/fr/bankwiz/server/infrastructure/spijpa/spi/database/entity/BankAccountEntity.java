package fr.bankwiz.server.infrastructure.spijpa.spi.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "BANK_ACCOUNTS")
public class BankAccountEntity {

    @Id
    @Column(name = "BANK_ACCOUNT_ID", nullable = false, updatable = false, insertable = false)
    private UUID id;

    @Column(name = "BANK_ACCOUNT_NAME", nullable = false)
    private String accountName;

    @Column(name = "INITIAL_DECIMAL_BALANCE", nullable = false)
    private Integer initialDecimalBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CURRENCY_ID", nullable=false)
    private CurrencyEntity currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID", nullable=false)
    private UserEntity user;

}
