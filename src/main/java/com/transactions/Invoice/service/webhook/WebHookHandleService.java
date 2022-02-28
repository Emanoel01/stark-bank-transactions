package com.transactions.Invoice.service.webhook;

import com.transactions.Invoice.domain.models.Invoice;
import com.transactions.Invoice.domain.models.webhook.Invoice.LogInvoice;
import com.transactions.Invoice.domain.models.webhook.Invoice.WebhookInvoice;
import com.transactions.Invoice.domain.usecases.webhook.invoice.WebHookHandlerInvoice;
import com.transactions.Invoice.infra.entities.BankAccountEntity;
import com.transactions.Invoice.infra.entities.TransferEntity;
import com.transactions.Invoice.infra.protocols.bankAccount.FindBankAccountByTaxIDRepository;
import com.transactions.Invoice.infra.protocols.transfer.CreateTransferRepository;
import com.transactions.Invoice.utils.enums.INVOICE_STATUS;

public class WebHookHandleService implements WebHookHandlerInvoice {

    private CreateTransferRepository createTransferRepository;
    private FindBankAccountByTaxIDRepository findBankAccountByTaxIDRepository;

    public WebHookHandleService (CreateTransferRepository createTransferRepository,
                                 FindBankAccountByTaxIDRepository findBankAccountByTaxIDRepository){
        this.createTransferRepository = createTransferRepository;
        this.findBankAccountByTaxIDRepository = findBankAccountByTaxIDRepository;
    }

    @Override
    public Boolean handle(WebhookInvoice webhook) throws Exception {

        LogInvoice logInvoice = webhook.getEvent().getLog();

        Invoice invoice = logInvoice.getInvoice();

        String typeUpperCase = logInvoice.getType().toUpperCase();

        if(typeUpperCase.equals(INVOICE_STATUS.CREDITED.toString())){
            TransferEntity transferEntity = new TransferEntity();
            Integer finalAmount = (invoice.getAmount() - invoice.getDiscountAmount());

            transferEntity.setAmount(finalAmount);
            transferEntity.setTags(invoice.getTags());

            BankAccountEntity bankAccountEntity = this.findBankAccountByTaxIDRepository.findBankAccountByTaxID("20.018.183/0001-80");

//            System.out.println(bankAccountEntity);

            if(bankAccountEntity == null) throw new Error("BANK_ACCOUNT_NOT_FOUND");

            Boolean resultCreateTransfer = this.createTransferRepository.createTransfer(transferEntity,bankAccountEntity);

            return resultCreateTransfer;
        }

        return true;
    }
}
