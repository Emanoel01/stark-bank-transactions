package com.transactions.Invoice.infra.entities;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Data;
import org.springframework.cloud.gcp.data.firestore.Document;

@Document(collectionName = "stark-bank-configuration")
@Data
public class StarkBankConfigurationEntity {
    @DocumentId
    private String id;

    private String projectId;
}
