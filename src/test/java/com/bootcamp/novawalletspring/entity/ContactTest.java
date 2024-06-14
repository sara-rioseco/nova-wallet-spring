package com.bootcamp.novawalletspring.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    private Contact contact;
    private User contactUser;
    private User ownerUser;
    private Timestamp creationDate;

    @BeforeEach
    void setUp() {
        creationDate = Timestamp.from(Instant.now());
        contactUser = new User();
        contactUser.setId(1);
        contactUser.setFirstName("Jane");
        contactUser.setLastName("Doe");
        contactUser.setUsername("jane.doe@example.com");

        ownerUser = new User();
        ownerUser.setId(2);
        ownerUser.setFirstName("John");
        ownerUser.setLastName("Smith");
        ownerUser.setUsername("john.smith@example.com");

        contact = new Contact();
        contact.setId(1);
        contact.setFirstName("Alice");
        contact.setLastName("Brown");
        contact.setUsername("alice.brown");
        contact.setContactUser(contactUser);
        contact.setOwnerUser(ownerUser);
        contact.setCreationDate(creationDate);
    }

    @Test
    void testGetId() {
        assertEquals(1, contact.getId());
    }

    @Test
    void testGetFirstName() {
        assertEquals("Alice", contact.getFirstName());
    }

    @Test
    void testGetLastName() {
        assertEquals("Brown", contact.getLastName());
    }

    @Test
    void testGetUsername() {
        assertEquals("alice.brown", contact.getUsername());
    }

    @Test
    void testGetContactUser() {
        assertEquals(contactUser, contact.getContactUser());
    }

    @Test
    void testGetOwnerUser() {
        assertEquals(ownerUser, contact.getOwnerUser());
    }

    @Test
    void testGetCreationDate() {
        assertNotNull(contact.getCreationDate());
    }

    @Test
    void testSetId() {
        contact.setId(2);
        assertEquals(2, contact.getId());
    }

    @Test
    void testSetFirstName() {
        contact.setFirstName("Bob");
        assertEquals("Bob", contact.getFirstName());
    }

    @Test
    void testSetLastName() {
        contact.setLastName("Johnson");
        assertEquals("Johnson", contact.getLastName());
    }

    @Test
    void testSetUsername() {
        contact.setUsername("bob.johnson");
        assertEquals("bob.johnson", contact.getUsername());
    }

    @Test
    void testSetContactUser() {
        User newContactUser = new User();
        newContactUser.setId(3);
        newContactUser.setFirstName("Charlie");
        newContactUser.setLastName("Green");
        newContactUser.setUsername("charlie.green@example.com");

        contact.setContactUser(newContactUser);
        assertEquals(newContactUser, contact.getContactUser());
    }

    @Test
    void testSetOwnerUser() {
        User newOwnerUser = new User();
        newOwnerUser.setId(4);
        newOwnerUser.setFirstName("Dana");
        newOwnerUser.setLastName("White");
        newOwnerUser.setUsername("dana.white@example.com");

        contact.setOwnerUser(newOwnerUser);
        assertEquals(newOwnerUser, contact.getOwnerUser());
    }

    @Test
    void testSetCreationDate() {
        contact.setCreationDate(creationDate);
        assertEquals(creationDate, contact.getCreationDate());
    }

    @Test
    void testEqualsAndHashCode() {
        Contact anotherContact = new Contact();
        anotherContact.setId(1);
        anotherContact.setFirstName("Alice");
        anotherContact.setLastName("Brown");
        anotherContact.setUsername("alice.brown");
        anotherContact.setContactUser(contactUser);
        anotherContact.setOwnerUser(ownerUser);
        anotherContact.setCreationDate(creationDate);

        assertEquals(contact, anotherContact);
        assertEquals(contact.hashCode(), anotherContact.hashCode());
    }

    @Test
    void testToString() {
        String expected = "Contact(id=1, firstName=Alice, lastName=Brown, username=alice.brown, contactUser=User(id=1, firstName=Jane, lastName=Doe, username=jane.doe@example.com, password=null, role=ROLE_USER, creationDate=null, isEnabled=true, accountNoExpired=true, accountNoLocked=true, credentialNoExpired=true), ownerUser=User(id=2, firstName=John, lastName=Smith, username=john.smith@example.com, password=null, role=ROLE_USER, creationDate=null, isEnabled=true, accountNoExpired=true, accountNoLocked=true, credentialNoExpired=true), creationDate="+creationDate.toString()+")";
        assertEquals(expected, contact.toString());
    }
}