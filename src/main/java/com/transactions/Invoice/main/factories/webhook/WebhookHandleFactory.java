package com.transactions.Invoice.main.factories.webhook;

import com.transactions.Invoice.domain.usecases.webhook.invoice.WebHookHandlerInvoice;
import com.transactions.Invoice.infra.protocols.bankAccount.FindBankAccountByTaxIDRepository;
import com.transactions.Invoice.infra.protocols.transfer.CreateTransferRepository;
import com.transactions.Invoice.service.webhook.WebHookHandleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebhookHandleFactory {

    @Bean
    WebHookHandlerInvoice webhookHandleService(CreateTransferRepository createTransferRepository, FindBankAccountByTaxIDRepository findBankAccountByTaxIDRepository){
        return new WebHookHandleService(createTransferRepository, findBankAccountByTaxIDRepository);
    }

}
