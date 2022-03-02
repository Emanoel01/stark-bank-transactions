package com.transactions.Invoice.infra.implementations.invoice;
import com.starkbank.Invoice;
import com.transactions.Invoice.infra.entities.InvoiceEntity;
import com.transactions.Invoice.infra.protocols.invoice.CreateInvoiceRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class InvoiceRepository implements CreateInvoiceRepository {

    @Override
    public Boolean create(InvoiceEntity invoiceEntity) throws Exception {
        List<Invoice> invoices = new ArrayList<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", invoiceEntity.getAmount());

        if(invoiceEntity.getDue() != null){
            data.put("due", invoiceEntity.getDue());
        }
        data.put("taxId", invoiceEntity.getTaxId());
        data.put("name", invoiceEntity.getName());

        invoices.add(new Invoice(data));
        invoices = Invoice.create(invoices);

        for (Invoice invoice : invoices) {
            if (!invoice.status.equals("created")) return false;
        }

        return true;
    }
}
