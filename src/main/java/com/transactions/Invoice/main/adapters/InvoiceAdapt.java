package com.transactions.Invoice.main.adapters;

import com.transactions.Invoice.domain.models.Invoice;
import com.transactions.Invoice.infra.entities.InvoiceEntity;
import org.springframework.beans.BeanUtils;

public class InvoiceAdapt {

    public static InvoiceEntity invoiceToInvoiceEntity(Invoice invoice){
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        BeanUtils.copyProperties(invoice, invoiceEntity);
        return invoiceEntity;
    }

}
