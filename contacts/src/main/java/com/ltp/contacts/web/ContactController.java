package com.ltp.contacts.web;

import com.ltp.contacts.exception.NoContactException;
import com.ltp.contacts.pojo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.ltp.contacts.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact/all")
    public ResponseEntity<List<Contact>> getAll(){
        List<Contact> contacts  = contactService.getContacts();
        return new ResponseEntity<>(contacts,HttpStatus.OK);
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
        try {
            Contact contact = contactService.getContactById(id);
            return new ResponseEntity<>(contact, HttpStatus.OK);
        }
        catch (NoContactException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/contact")
    public ResponseEntity<HttpStatus> postContact(@RequestBody Contact contact){
        contactService.saveContact(contact);
        System.out.println(contact.getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable String id, @RequestBody Contact contact) {
        try {
            contactService.updateContact(id,contact);
            return new ResponseEntity<>(contactService.getContactById(id),HttpStatus.ACCEPTED);
        }

        catch (NoContactException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id) {
        try {
            contactService.deleteContact(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (NoContactException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
