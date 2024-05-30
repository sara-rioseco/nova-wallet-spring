package com.bootcamp.novawalletspring.repository;

import com.bootcamp.novawalletspring.model.Contact;

import java.util.List;

public interface ContactRepository {
    boolean createContact(Contact contact);
    Contact getContactById(int id);
    int getContactUserIdByContactId(int id);
    boolean updateContact(Contact contact);
    boolean deleteContact(int id);
    List<Contact> getAllContacts();
    List<Contact> getAllContactsByOwnerId(int ownerId);
}
