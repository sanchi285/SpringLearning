package com.ltp.contacts;

import com.ltp.contacts.exception.ContactNotFoundException;
import com.ltp.contacts.exception.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<Object> handleContactnotFoundException(ContactNotFoundException ex){
        ErrorResponse er = new ErrorResponse(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
      //  System.out.println(ex.getBindingResult().getAllErrors());
        List<String> errmsg =  new ArrayList<>();
        for(ObjectError err : ex.getBindingResult().getAllErrors()){
            System.out.println(err.getDefaultMessage());
            errmsg.add(err.getDefaultMessage());
        }
        ErrorResponse er = new ErrorResponse(errmsg);
        return new ResponseEntity<>(er,HttpStatus.BAD_REQUEST);
    }
}
