package com.bootcamp.novawalletspring.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * The type Account.
 */
@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    @ColumnDefault("0")
    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.valueOf(0);

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Timestamp creationDate;

}