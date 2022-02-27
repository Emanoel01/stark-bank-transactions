package com.transactions.Invoice.domain.usecases.invoice;

import com.transactions.Invoice.domain.models.Invoice;

public interface CreateInvoice {

    Boolean create(Invoice invoice) throws Exception;

}
