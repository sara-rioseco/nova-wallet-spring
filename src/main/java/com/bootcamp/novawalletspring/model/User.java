package com.bootcamp.novawalletspring.model;

import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private final Timestamp creationDate;


    public User(int id, String firstName, String lastName, String email, String password, Timestamp creationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.creationDate = creationDate;
    }

    public User(String firstName, String lastName, String email, String password) {
        this(0, firstName, lastName, email, password, Timestamp.from(Instant.now()));
    }
    public User(User user) {
        this(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getCreationDate());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }
}
