package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.entity.ContactEntity;
import com.bootcamp.novawalletspring.model.Contact;
import com.bootcamp.novawalletspring.repository.ContactRepository;
import com.bootcamp.novawalletspring.repository.UserRepository;
import com.bootcamp.novawalletspring.service.ContactService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@CommonsLog
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean createContact(Contact contact) {
        if (contact != null
                && contact.getFirstName() !=null
                && !contact.getFirstName().isBlank()
                && contact.getEmail() !=null
                && !contact.getEmail().isBlank()
                && userRepository.getByEmail(contact.getEmail()) != null
                && userRepository.getById(contact.getContactUserId()) != null
                && userRepository.getById(contact.getOwnerUserId()) != null ) {
            return contactRepository.save(contact) > 0;
        } else {
            System.out.println("Error creating user");
            return false;
        }
    }

    @Override
    public Contact getContactById(int id) {
        return new Contact(contactRepository.getById(id));
    }

    @Override
    public int getContactUserIdByContactId(int id) {
        return contactRepository.getContactUserIdByContactId(id);
    }

    @Override
    public boolean updateContact(Contact contact) {
        if (contact != null
                && contactRepository.getById(contact.getId()) != null
                && contact.getFirstName() !=null
                && !contact.getFirstName().isBlank()
                && contact.getEmail() !=null
                && !contact.getEmail().isBlank()) {
            return contactRepository.update(contact, contact.getId()) > 0;
        } else {
            System.out.println("Error updating contact");
            return false;
        }
    }

    @Override
    public boolean deleteContact(int id) {
        if (contactRepository.getById(id) != null) {
            return contactRepository.delete(id) > 0;
        } else {
            System.out.println("Error deleting contact");
            return false;
        }
    }

    @Override
    public List<Contact> getAllContacts() {
        List<ContactEntity> contacts = contactRepository.getAll();
        List<Contact> result = new ArrayList<>();
        for (ContactEntity contact : contacts) {
            result.add(new Contact(contact));
        }
        return result;
    }

    @Override
    public List<Contact> getAllContactsByOwnerId(int ownerId) {
        List<ContactEntity> contacts = contactRepository.getAllByOwnerId(ownerId);
        List<Contact> result = new ArrayList<>();
        for (ContactEntity contact : contacts) {
            result.add(new Contact(contact));
        }
        return result;
    }
}
