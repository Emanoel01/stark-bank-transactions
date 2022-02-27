package com.transactions.Invoice.domain.models.webhook.Invoice;

import com.transactions.Invoice.domain.models.webhook.Event;
import lombok.Data;

@Data
public class EventInvoice extends Event {
    private LogInvoice log;
}
