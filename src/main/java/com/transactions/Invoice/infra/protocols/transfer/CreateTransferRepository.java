package com.transactions.Invoice.infra.protocols.transfer;

import com.transactions.Invoice.infra.entities.BankAccountEntity;
import com.transactions.Invoice.infra.entities.TransferEntity;
import com.transactions.Invoice.main.config.classes.StartBankConfiguration;

public interface CreateTransferRepository {
    Boolean createTransfer(TransferEntity transferEntity, BankAccountEntity bankAccountEntity) throws Exception;
}
