package com.ltp.contacts.service;

import java.util.List;

import com.ltp.contacts.pojo.Contact;

public interface ContactService {

    public List <Contact> getAllContact();
    public Contact getContactById(String id);
    public void saveContact(Contact contact);
    public void upadateContact(String id, Contact contact);
    public void deleteContact(String id);
}
