package com.bootcamp.novawalletspring.rest;

import com.bootcamp.novawalletspring.entity.Contact;
import com.bootcamp.novawalletspring.entity.Currency;
import com.bootcamp.novawalletspring.entity.User;
import com.bootcamp.novawalletspring.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/contact")
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping
    public Iterable<Contact> getContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getById(@PathVariable int id) {
        return contactService.getContactById(id);
    }

    @GetMapping("/user/{id}")
    public User getContactUserByContactId(@PathVariable int id) {
        return contactService.getContactUserByContactId(id);
    }

    @GetMapping("/owner/{ownerId}")
    public Iterable<Contact> getAllContactsByOwnerId(@PathVariable int ownerId) {
        return contactService.getAllContactsByOwnerId(ownerId);
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @PatchMapping
    public Contact updateContact(@RequestBody Contact contact) {
        return contactService.updateContact(contact);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCurrency(@PathVariable int id) {
        return contactService.deleteContact(id);
    }
}
