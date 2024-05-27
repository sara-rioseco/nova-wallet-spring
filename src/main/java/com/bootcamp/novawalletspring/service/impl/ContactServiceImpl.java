package com.bootcamp.novawalletspring.service.impl;

import com.bootcamp.novawalletspring.repository.ContactRepository;
import com.bootcamp.novawalletspring.repository.UserRepository;
import com.bootcamp.novawalletspring.repository.impl.UserRepositoryImpl;
import com.bootcamp.novawalletspring.model.Contact;
import com.bootcamp.novawalletspring.service.ContactService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CommonsLog
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public boolean createContact(Contact contact) {
        UserRepository userRepository = new UserRepositoryImpl();
        if (contact != null
                && contact.getFirstName() !=null
                && !contact.getFirstName().isBlank()
                && contact.getEmail() !=null
                && !contact.getEmail().isBlank()
                && userRepository.getUserByEmail(contact.getEmail()) != null
                && userRepository.getUserById(contact.getContactUserId()) != null
                && userRepository.getUserById(contact.getOwnerUserId()) != null ) {
            return contactRepository.addContact(contact);
        } else {
            System.out.println("Error creating user");
            return false;
        }
    }

    @Override
    public Contact getContactById(int id) {
        return contactRepository.getContactById(id);
    }

    @Override
    public int getContactUserIdByContactId(int id) {
        return contactRepository.getContactUserIdByContactId(id);
    }

    @Override
    public boolean updateContact(Contact contact) {
        if (contact != null
                && contactRepository.getContactById(contact.getId()) != null
                && contact.getFirstName() !=null
                && !contact.getFirstName().isBlank()
                && contact.getEmail() !=null
                && !contact.getEmail().isBlank()) {
            return contactRepository.updateContact(contact);
        } else {
            System.out.println("Error updating contact");
            return false;
        }
    }

    @Override
    public boolean deleteContact(int id) {
        if (contactRepository.getContactById(id) != null) {
            return contactRepository.deleteContact(id);
        } else {
            System.out.println("Error deleting contact");
            return false;
        }
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.getAllContacts();
    }

    @Override
    public List<Contact> getAllContactsByOwnerId(int ownerId) {
        return contactRepository.getContactsByOwnerId(ownerId);
    }
}
