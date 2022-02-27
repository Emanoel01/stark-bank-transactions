package com.transactions.Invoice.main.adapters;

import com.transactions.Invoice.domain.models.Invoice;
import com.transactions.Invoice.domain.models.webhook.Invoice.EventInvoice;
import com.transactions.Invoice.domain.models.webhook.Invoice.LogInvoice;
import com.transactions.Invoice.domain.models.webhook.Invoice.WebhookInvoice;
import com.transactions.Invoice.presentation.controllers.dtos.invoice.EventInvoiceDTO;
import com.transactions.Invoice.presentation.controllers.dtos.invoice.LogInvoiceDTO;
import com.transactions.Invoice.presentation.controllers.dtos.invoice.WebhookInvoiceDTO;
import org.springframework.beans.BeanUtils;

public class WebhookAdapt {

    public static WebhookInvoice adaptWebhookDTOToWebhookInvoice(WebhookInvoiceDTO webhookInvoiceDTODTO){
        WebhookInvoice webhook = new WebhookInvoice();

        EventInvoiceDTO eventDTO = webhookInvoiceDTODTO.getEvent();
        LogInvoiceDTO logDTO =  eventDTO.getLog();

        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(logDTO.getInvoice(), invoice);

        LogInvoice log = new LogInvoice();
        BeanUtils.copyProperties(logDTO, log);
        log.setInvoice(invoice);

        EventInvoice event = new EventInvoice();
        BeanUtils.copyProperties(eventDTO, event);
        event.setLog(log);

        webhook.setEvent(event);

        return webhook;
    }

}
