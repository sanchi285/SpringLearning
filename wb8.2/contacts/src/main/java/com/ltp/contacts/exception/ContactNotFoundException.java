package com.ltp.contacts.exception;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(String id){
        super("The id"+ id + "Doesn't exist in record");
    }
}
