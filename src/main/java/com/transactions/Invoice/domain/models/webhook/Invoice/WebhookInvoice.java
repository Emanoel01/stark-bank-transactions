package com.transactions.Invoice.domain.models.webhook.Invoice;

import com.transactions.Invoice.domain.models.webhook.Event;
import com.transactions.Invoice.domain.models.webhook.Webhook;
import lombok.Data;

@Data
public class WebhookInvoice extends Webhook {
    private EventInvoice event;
}
