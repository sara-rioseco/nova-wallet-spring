package com.bootcamp.novawalletspring.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

/**
 * The type Contact.
 */
@Data
@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contact_user_id", nullable = false)
    private User contactUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_user_id", nullable = false)
    private User ownerUser;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Timestamp creationDate;

}