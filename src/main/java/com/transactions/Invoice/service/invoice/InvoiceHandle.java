package com.transactions.Invoice.service.invoice;

import com.transactions.Invoice.domain.models.Invoice;
import com.transactions.Invoice.domain.usecases.invoice.CreateInvoice;
import com.transactions.Invoice.infra.entities.InvoiceEntity;
import com.transactions.Invoice.infra.protocols.invoice.CreateInvoiceRepository;
import com.transactions.Invoice.main.adapters.InvoiceAdapt;

public class InvoiceHandle implements CreateInvoice {

    private CreateInvoiceRepository createInvoiceRepository;

    public InvoiceHandle(CreateInvoiceRepository createInvoiceRepository){this.createInvoiceRepository =  createInvoiceRepository;}

    @Override
    public Boolean create(Invoice invoice) throws Exception {

        InvoiceEntity invoiceEntity = InvoiceAdapt.invoiceToInvoiceEntity(invoice);

        Boolean result = this.createInvoiceRepository.create(invoiceEntity);

        return result;
    }
}
