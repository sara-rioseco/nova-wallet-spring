package com.bootcamp.novawalletspring.service;

import com.bootcamp.novawalletspring.entity.Contact;
import com.bootcamp.novawalletspring.entity.User;

public interface ContactService {
    Contact createContact(Contact contact);
    Contact getContactById(int id);
    User getContactUserByContactId(int id);
    Contact updateContact(Contact contact);
    boolean deleteContact(int id);
    Iterable<Contact> getAllContacts();
    Iterable<Contact> getAllContactsByOwnerId(int ownerId);
}
