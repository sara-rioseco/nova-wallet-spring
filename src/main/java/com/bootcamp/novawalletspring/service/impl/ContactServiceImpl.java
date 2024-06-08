package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.entity.Contact;
import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.repository.ContactRepository;
import com.bootcamp.novawalletspring.service.ContactService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CommonsLog
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact createContact(Contact contact) {
        try {
            return contactRepository.save(contact);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Contact getContactById(int id) {
        try {
            Optional<Contact> con = contactRepository.findById(id);
            if (con.isPresent()) {
                return con.get();
            }
            else {
                throw new Exception("Error getting contact");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public User getContactUserByContactId(int id) {
        try {
            return contactRepository.findContactUserByContactId(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Contact updateContact(Contact contact) {
        if(contactRepository.existsById(contact.getId())) {
            try {
                return contactRepository.save(contact);
            } catch (Exception e) {
                log.error(e.getMessage());
                return null;
            }
        } else {
            log.error("Contact not found");
            return null;
        }
    }

    @Override
    public boolean deleteContact(int id) {
        try {
            contactRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Iterable<Contact> getAllContacts() {
        try {
            Iterable<Contact> contacts = contactRepository.findAll();
            if (contacts.iterator().hasNext()) {
                return contacts;
            }
            else {
                throw new Exception("Error getting contacts");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Iterable<Contact> getAllContactsByOwnerId(int ownerId) {
        try {
            Iterable<Contact> contacts = contactRepository.findAllByOwnerId(ownerId);
            if (contacts.iterator().hasNext()) {
                return contacts;
            }
            else {
                throw new Exception("Error getting contacts");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
