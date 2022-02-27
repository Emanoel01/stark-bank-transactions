package com.transactions.Invoice.infra.entities;

import lombok.Data;

@Data
public class BankAccountEntity {
    private String bankCode;
    private String branch;
    private String account;
    private String name;
    private String taxID;
    private String accountType;
}
