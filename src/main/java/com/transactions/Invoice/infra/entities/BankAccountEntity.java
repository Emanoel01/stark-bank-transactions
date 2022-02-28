package com.transactions.Invoice.infra.entities;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;
import org.springframework.cloud.gcp.data.firestore.Document;

@Data
@Document(collectionName = "stark-bank-account")
public class BankAccountEntity {
    @DocumentId
    private String id;
    private String bankCode;
    private String branch;
    private String account;
    private String name;
    private String taxID;
    private String accountType;
}
