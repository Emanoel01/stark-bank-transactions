package com.transactions.Invoice.main.config.classes;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("stark-bank")
@Data
public class StartBankConfiguration {
    private String projectId;
    private String bankCode;
    private String branch;
    private String account;
    private String name;
    private String taxID;
    private String accountType;
}
