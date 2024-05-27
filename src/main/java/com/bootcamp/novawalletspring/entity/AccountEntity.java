package com.bootcamp.novawalletspring.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Data
@Entity
@Table(name = "accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity ownerId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "currency_id", nullable = false)
    private CurrencyEntity currencyId;

    @ColumnDefault("0")
    @Column(name = "balance", nullable = false)
    private Integer balance;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "creation_date", nullable = false)
    private Instant creationDate;

}