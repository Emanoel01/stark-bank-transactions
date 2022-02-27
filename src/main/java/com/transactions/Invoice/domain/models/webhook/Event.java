package com.transactions.Invoice.domain.models.webhook;

import lombok.Data;

import java.util.Date;

@Data
public class Event {

    private String id;
    private String subscription;
    private Boolean isDelivered;
    private Date created;
    private Log log;


}
