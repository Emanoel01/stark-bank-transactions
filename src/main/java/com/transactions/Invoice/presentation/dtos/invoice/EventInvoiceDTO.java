package com.transactions.Invoice.presentation.dtos.invoice;

import com.transactions.Invoice.presentation.dtos.base.EventDTO;
import lombok.Data;

@Data
public class EventInvoiceDTO extends EventDTO {

    private LogInvoiceDTO log;
}
