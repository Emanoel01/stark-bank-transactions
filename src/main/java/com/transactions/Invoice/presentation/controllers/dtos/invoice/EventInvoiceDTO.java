package com.transactions.Invoice.presentation.controllers.dtos.invoice;

import com.transactions.Invoice.presentation.controllers.dtos.base.EventDTO;
import lombok.Data;

@Data
public class EventInvoiceDTO extends EventDTO {

    private LogInvoiceDTO log;
}
