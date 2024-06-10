package com.bootcamp.novawalletspring.entity;

import com.bootcamp.novawalletspring.model.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

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

    @Column(name = "role", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private Role role;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Instant creationDate;

    @Column(name ="is_enabled")
    private boolean isEnabled;

    @Column(name ="account_no_expired")
    private boolean accountNoExpired;

    @Column(name ="account_no_locked")
    private boolean accountNoLocked;

    @Column(name ="credential_no_expired")
    private boolean credentialNoExpired;
}