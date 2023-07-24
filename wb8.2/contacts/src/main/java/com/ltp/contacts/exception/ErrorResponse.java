package com.ltp.contacts.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

    private List<String> message = new ArrayList<>();
    private LocalDateTime localDateTime;

    public ErrorResponse(List<String> message) {
        this.message = message;
        this.localDateTime = LocalDateTime.now();
    }


    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }


}
