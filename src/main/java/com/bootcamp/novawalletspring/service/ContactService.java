package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.entity.Contact;
import com.bootcamp.novawalletspring.entity.User;

/**
 * The interface Contact service.
 */
public interface ContactService {
    /**
     * Create contact.
     *
     * @param contact the contact
     * @return the contact
     */
    Contact createContact(Contact contact);

    /**
     * Gets contact by id.
     *
     * @param id the id
     * @return the contact by id
     */
    Contact getContactById(int id);

    /**
     * Gets contact's user entity by contact id.
     *
     * @param id the id
     * @return the contact user by contact id
     */
    User getContactUserByContactId(int id);

    /**
     * Update contact.
     *
     * @param contact the contact
     * @return the contact
     */
    Contact updateContact(Contact contact);

    /**
     * Delete contact.
     *
     * @param id the id
     * @return the boolean
     */
    boolean deleteContact(int id);

    /**
     * Gets all contacts.
     *
     * @return the all contacts
     */
    Iterable<Contact> getAllContacts();

    /**
     * Gets all contacts by owner id.
     *
     * @param ownerId the owner id
     * @return the all contacts by owner id
     */
    Iterable<Contact> getAllContactsByOwnerId(int ownerId);
}
