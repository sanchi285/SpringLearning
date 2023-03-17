package com.ltp.contacts.service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    
    @Override
    public List<Contact> getAllContact(){
        return contactRepository.getContacts();
    }

    @Override
    public Contact getContactById(String id){
        return contactRepository.getContact(findIndexById(id));
    }

    @Override
    public void saveContact(Contact contact){
        contactRepository.saveContact(contact);
    }

    @Override
    public void upadateContact(String id, Contact contact){
        int idx = findIndexById(id);
        contactRepository.updateContact(idx, contact);
    }

    @Override
    public void deleteContact(String id){
        int idx = findIndexById(id);
        contactRepository.deleteContact(idx);
    }

    private int findIndexById(String id) {
        return IntStream.range(0, contactRepository.getContacts().size())
            .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
            .findFirst()
            .orElseThrow();
    }

}
