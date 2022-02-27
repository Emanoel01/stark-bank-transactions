package com.transactions.Invoice.presentation.controllers.dtos.invoice;

import com.transactions.Invoice.presentation.controllers.dtos.base.LogDTO;
import lombok.Data;

@Data
public class LogInvoiceDTO extends LogDTO {
    private InvoiceDTO invoice;
}
