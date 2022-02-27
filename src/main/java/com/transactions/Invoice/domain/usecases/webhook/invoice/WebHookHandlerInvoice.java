package com.transactions.Invoice.domain.usecases.webhook.invoice;

import com.transactions.Invoice.domain.models.webhook.Invoice.WebhookInvoice;
import com.transactions.Invoice.domain.models.webhook.Webhook;

public interface WebHookHandlerInvoice {

    Boolean handle(WebhookInvoice webhook) throws Exception;

}
