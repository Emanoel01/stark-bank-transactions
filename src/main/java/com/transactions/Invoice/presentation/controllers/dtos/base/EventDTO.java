package com.transactions.Invoice.presentation.controllers.dtos.base;

import lombok.Data;

import java.util.Date;

@Data
public class EventDTO {

    private String id;
    private String subscription;
    private Boolean isDelivered;
    private Date created;
}
