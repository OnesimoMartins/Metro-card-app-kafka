package com.metrocard.reportsservice.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmailException extends RuntimeException {
    public EmailException(String msg) {
        super(msg);
    }
}
