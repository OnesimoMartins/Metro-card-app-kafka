package com.metrocard.reportsservice.listener;

import com.metrocard.reportsservice.config.MailDetails;
import com.metrocard.reportsservice.config.kafka.KafkaListenerConfig;
import com.metrocard.reportsservice.event.NewPassengerEvent;
import com.metrocard.reportsservice.kafka.Topic;
import com.metrocard.reportsservice.kafka.errohandler.ErrorHandler;
import com.metrocard.reportsservice.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PassengerListener {

    private final EmailService emailService;
    private final MailDetails mailProperties;

    @RetryableTopic
    @KafkaListener(topics = Topic.NEW_PASSENGER, groupId = KafkaListenerConfig.GROUP_ID,
            containerFactory = KafkaListenerConfig.CONTAINER_FACTORY,
            errorHandler = ErrorHandler.EMAIL_ERROR_HANDLER
    )
    public void onNewPassengerCreated(NewPassengerEvent newPassenger){

        emailService.sendMail(EmailService.Message.builder()
                        .body("emails/welcome-mail.html")
                        .from(mailProperties.getFrom())
                        .to(newPassenger.getEmail())
                        .subject("Bem-vindo(a) ao Metro Card")
                        .variable("name",newPassenger.getName())
                        .variable("lastName",newPassenger.getLastName())
                .build());

      log.info("Novo cliente criado {}",newPassenger);
    }

}
