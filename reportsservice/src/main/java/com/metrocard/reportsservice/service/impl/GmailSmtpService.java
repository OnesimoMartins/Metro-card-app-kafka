package com.metrocard.reportsservice.service.impl;

import com.metrocard.reportsservice.exception.EmailException;
import com.metrocard.reportsservice.service.EmailService;
import freemarker.template.Configuration;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class GmailSmtpService implements EmailService {

    private final JavaMailSender sender;
    private final Configuration configuration;

    @Override
    public void sendMail(@NonNull Message message) {
        try {
        sender.send(getMimeMessage(message));
        }catch (MessagingException e){
           //TODO log to the error logger
        }
    }

    private MimeMessage getMimeMessage(Message message) throws MessagingException {

        var mimeMessage=sender.createMimeMessage();
        var mimeMessageHelper=new MimeMessageHelper(mimeMessage);

        var html=processMessageTemplate(message.getBody(), message.getVariables());

        mimeMessageHelper.addTo(message.getTo());
        mimeMessageHelper.setFrom(message.getFrom());
        mimeMessageHelper.setSubject(message.getSubject());
        mimeMessageHelper.setText(html,true);

        return mimeMessage;
    }

    private String  processMessageTemplate(String templateSrc,Map<String,String> variables){

        try {
            var template=configuration.getTemplate(templateSrc);
            return FreeMarkerTemplateUtils.processTemplateIntoString(template,variables);
        } catch (Exception e) {
            throw new EmailException("não foi possível processar template");
        }
    }

}
