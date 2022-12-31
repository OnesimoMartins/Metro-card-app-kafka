package com.metrocard.reportsservice.kafka.errohandler;

import com.metrocard.reportsservice.exception.EmailException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.lang.NonNull;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailExceptionHandler implements KafkaListenerErrorHandler {

    @Override
    public Object handleError(Message<?> message,ListenerExecutionFailedException e) {
        log.error("Ocorreu um erro ao enviar email");
        throw new EmailException();
    }

}
