package com.metrocard.reportsservice.config.mail;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:/mail.properties")
@AllArgsConstructor
public class MailConfig {

    private final Environment env;

    @Bean
    public JavaMailSender javaMailSender(){
        var mailSender= new JavaMailSenderImpl();
        var properties=new Properties();
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.transport.protocol","smtp");
        properties.put("mail.smtp.auth","true");

        mailSender.setJavaMailProperties(properties);
        mailSender.setPassword(env.getProperty("mail.password"));
        mailSender.setPort(env.getProperty("mail.port",Integer.class));
        mailSender.setUsername(env.getProperty("mail.username"));
        mailSender.setHost(env.getProperty("mail.host"));

        return mailSender;
    }

}
