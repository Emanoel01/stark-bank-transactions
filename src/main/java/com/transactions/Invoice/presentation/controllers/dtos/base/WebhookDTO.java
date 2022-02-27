package com.transactions.Invoice.presentation.controllers.dtos.base;



import lombok.Data;

@Data
public class WebhookDTO {
    private EventDTO event;
}
