package com.ltp.contacts;

import com.ltp.contacts.exception.ContactNotFoundException;
import com.ltp.contacts.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<Object> handleContactnotFoundException(ContactNotFoundException ex){
        ErrorResponse er = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
    }

}
