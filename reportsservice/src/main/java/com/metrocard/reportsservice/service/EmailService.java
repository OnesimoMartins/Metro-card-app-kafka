package com.metrocard.reportsservice.service;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.Map;

public interface EmailService {

    void sendMail(Message message);

    @Builder
    @Getter
    @ToString
     class Message{
        private final String from;
        private final String to;
        private final String subject;
        private final String body;

        @Singular("variable")
        private final Map<String,String > variables;
    }

}
