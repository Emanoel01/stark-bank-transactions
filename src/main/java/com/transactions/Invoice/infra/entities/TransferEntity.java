package com.transactions.Invoice.infra.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class TransferEntity {

    private String id;
    private ArrayList<String> transactionsIds;
    private Date updated;
    private Date created;
    private Date schedule;
    private String status;
    private Integer fee;
    private ArrayList<String> tags;
    private String externalId;
    private String accountType;
    private String accountNumber;
    private String branchCode;
    private String bankCode;
    private String taxId;
    private String name;
    private Integer amount;

}
