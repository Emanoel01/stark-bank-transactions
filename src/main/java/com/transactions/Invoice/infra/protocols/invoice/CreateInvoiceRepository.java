package com.transactions.Invoice.infra.protocols.invoice;

import com.transactions.Invoice.infra.entities.InvoiceEntity;

public interface CreateInvoiceRepository {
    Boolean create(InvoiceEntity invoiceEntity) throws Exception;
}
