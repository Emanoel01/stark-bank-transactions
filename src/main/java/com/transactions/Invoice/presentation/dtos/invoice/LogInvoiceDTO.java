package com.transactions.Invoice.presentation.dtos.invoice;

import com.transactions.Invoice.presentation.dtos.base.LogDTO;
import lombok.Data;

@Data
public class LogInvoiceDTO extends LogDTO {
    private InvoiceDTO invoice;
}
