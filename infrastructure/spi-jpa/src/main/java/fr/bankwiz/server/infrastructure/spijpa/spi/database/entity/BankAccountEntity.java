package fr.bankwiz.server.infrastructure.spijpa.spi.database.entity;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name = "CURRENCY_ID", nullable = false)
    private CurrencyEntity currency;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity user;
}
