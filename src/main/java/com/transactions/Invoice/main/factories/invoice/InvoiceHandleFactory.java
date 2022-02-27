package com.transactions.Invoice.main.factories.invoice;

import com.transactions.Invoice.infra.protocols.invoice.CreateInvoiceRepository;
import com.transactions.Invoice.service.invoice.InvoiceHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InvoiceHandleFactory {

    @Bean
    public InvoiceHandle invoiceHandle(CreateInvoiceRepository createInvoiceRepository){
        return new InvoiceHandle(createInvoiceRepository);
    }

}
