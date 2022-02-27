package com.transactions.Invoice.domain.models;

import lombok.Data;

@Data
public class BankAccount {
    private String bankCode;
    private String branch;
    private String account;
    private String name;
    private String taxID;
    private String accountType;
}
