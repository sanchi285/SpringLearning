package com.ltp.contacts.service;

import com.ltp.contacts.pojo.Contact;

import java.util.List;

public interface ContactService {
    public Contact getContactById(String id);
    void saveContact(Contact contact);
    void updateContact(String id, Contact contact);
    void deleteContact(String id);
    List<Contact> getContacts();
}
