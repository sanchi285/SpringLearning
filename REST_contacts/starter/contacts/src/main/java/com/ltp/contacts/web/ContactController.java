package com.ltp.contacts.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.service.ContactService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.annotations.OpenAPI30;

@RestController
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @Tag(name="Section one")
    @Operation(summary="Get Contact",description = "It will get all contact")
    @GetMapping("/contact/all")
    public ResponseEntity<List<Contact>> getAllContact(){
        List<Contact> contacts =  contactService.getAllContact();
        return new ResponseEntity<>(contacts,HttpStatus.OK);
    }

    @Tag(name="Section one")
    @Operation(summary="Get Contact by Id",description = "It will bring a specific contact")
    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable String id){
        Contact contact = contactService.getContactById(id); 
        return new ResponseEntity<>(contact,HttpStatus.OK);
    }

    @Tag(name="Section two")
    @PostMapping("/contact")
    public ResponseEntity<HttpStatus> createContact(@RequestBody Contact contact){
        contactService.saveContact(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @Tag(name="Section two")
    @PutMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> updateContact(@PathVariable String id,@RequestBody Contact contact){
        contactService.upadateContact(id, contact);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @Tag(name="Section three")
    @DeleteMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id){
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
