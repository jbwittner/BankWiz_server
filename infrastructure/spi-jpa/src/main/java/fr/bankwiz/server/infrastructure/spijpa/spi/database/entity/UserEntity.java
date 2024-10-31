package fr.bankwiz.server.infrastructure.spijpa.spi.database.entity;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
@Table(name = "USER_ACCOUNTS")
public class UserEntity {

    @Id
    @Column(name = "USER_ID", nullable = false, updatable = false, insertable = false, columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(name = "AUTH_ID", nullable = false)
    private String authId;

    @Column(name = "NICK_NAME", nullable = false)
    private String nickName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;
}
