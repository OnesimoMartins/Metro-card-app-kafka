package com.metrocard.reportsservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("")
public class MailDetails {
    private String from="Metro Company <Ogouveia86@gmail.com>";
}
