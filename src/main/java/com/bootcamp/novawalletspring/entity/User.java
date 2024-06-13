package com.bootcamp.novawalletspring.entity;

import com.bootcamp.novawalletspring.model.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

/**
 * The type User.
 */
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(unique = true, name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @ColumnDefault("ROLE_USER")
    @Column(name = "role", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Timestamp creationDate;

    @ColumnDefault("true")
    @Column(name ="is_enabled")
    private boolean isEnabled = true;

    @ColumnDefault("true")
    @Column(name ="account_no_expired")
    private boolean accountNoExpired = true;

    @ColumnDefault("true")
    @Column(name ="account_no_locked", nullable = false)
    private boolean accountNoLocked = true;

    @ColumnDefault("true")
    @Column(name="credential_no_expired", nullable = false)
    private boolean credentialNoExpired = true;


}