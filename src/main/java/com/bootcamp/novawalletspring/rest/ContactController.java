package com.bootcamp.novawalletspring.rest;

import com.bootcamp.novawalletspring.entity.Contact;
import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.service.ContactService;
import org.springframework.web.bind.annotation.*;

/**
 * The type Contact rest controller.
 */
@RestController
@RequestMapping("api/contact")
public class ContactController {

    private final ContactService contactService;

    /**
     * Instantiates a new Contact controller.
     *
     * @param contactService the contact service
     */
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    /**
     * Gets contacts.
     *
     * @return the contacts
     */
    @GetMapping
    public Iterable<Contact> getContacts() {
        return contactService.getAllContacts();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @GetMapping("/{id}")
    public Contact getById(@PathVariable int id) {
        return contactService.getContactById(id);
    }

    /**
     * Gets contact user by contact id.
     *
     * @param id the id
     * @return the contact user by contact id
     */
    @GetMapping("/user/{id}")
    public User getContactUserByContactId(@PathVariable int id) {
        return contactService.getContactUserByContactId(id);
    }

    /**
     * Gets all contacts by owner id.
     *
     * @param ownerId the owner id
     * @return the all contacts by owner id
     */
    @GetMapping("/owner/{ownerId}")
    public Iterable<Contact> getAllContactsByOwnerId(@PathVariable int ownerId) {
        return contactService.getAllContactsByOwnerId(ownerId);
    }

    /**
     * Create contact.
     *
     * @param contact the contact
     * @return the contact
     */
    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    /**
     * Update contact.
     *
     * @param contact the contact
     * @return the contact
     */
    @PatchMapping
    public Contact updateContact(@RequestBody Contact contact) {
        return contactService.updateContact(contact);
    }

    /**
     * Delete contact.
     *
     * @param id the id
     * @return the boolean
     */
    @DeleteMapping("/{id}")
    public boolean deleteContact(@PathVariable int id) {
        return contactService.deleteContact(id);
    }
}
