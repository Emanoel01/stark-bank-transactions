package com.transactions.Invoice.presentation.dtos.invoice;

import com.transactions.Invoice.presentation.dtos.base.WebhookDTO;
import lombok.Data;

@Data
public class WebhookInvoiceDTO extends WebhookDTO {
    private EventInvoiceDTO event;
}
