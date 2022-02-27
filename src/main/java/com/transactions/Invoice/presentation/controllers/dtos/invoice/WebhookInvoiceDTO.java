package com.transactions.Invoice.presentation.controllers.dtos.invoice;

import com.transactions.Invoice.presentation.controllers.dtos.base.WebhookDTO;
import lombok.Data;

@Data
public class WebhookInvoiceDTO extends WebhookDTO {
    private EventInvoiceDTO event;
}
