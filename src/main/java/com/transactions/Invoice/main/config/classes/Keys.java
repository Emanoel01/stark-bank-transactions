package com.transactions.Invoice.main.config.classes;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("keys")
@Data
public class Keys {

    private  String path;

}
