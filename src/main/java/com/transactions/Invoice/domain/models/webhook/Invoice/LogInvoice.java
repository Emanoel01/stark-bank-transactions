package com.transactions.Invoice.domain.models.webhook.Invoice;

import com.transactions.Invoice.domain.models.Invoice;
import com.transactions.Invoice.domain.models.webhook.Log;
import lombok.Data;


@Data
public class LogInvoice extends Log {
    private Invoice invoice;
}
