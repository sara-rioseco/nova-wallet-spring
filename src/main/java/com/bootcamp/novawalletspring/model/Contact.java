package com.bootcamp.novawalletspring.model;

import com.bootcamp.novawalletspring.entity.ContactEntity;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Data
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private final int contactUserId;
    private final int ownerUserId;
    private final Timestamp creationDate;

    public Contact(int id, String firstName, String lastName, String email, int contactUserId, int ownerUserId, Timestamp creationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactUserId = contactUserId;
        this.ownerUserId = ownerUserId;
        this.creationDate = creationDate;
    }

    public Contact(String firstName, String email, int contactUserId, int ownerUserId) {
        this(0, firstName, null, email, contactUserId, ownerUserId, Timestamp.from(Instant.now()));
    }

    public Contact(ContactEntity contact) {
        this(contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getEmail(),
             contact.getContactUserId().getId(), contact.getOwnerUserId().getId(),
             Timestamp.from(contact.getCreationDate()));
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
        return firstName + (lastName != null ? " " + lastName : "");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContactUserId() {
        return contactUserId;
    }

    public int getOwnerUserId() {
        return ownerUserId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }
}
