package com.transactions.Invoice.infra.protocols.bankAccount;

import com.transactions.Invoice.infra.entities.BankAccountEntity;
import org.springframework.stereotype.Component;


public interface FindBankAccountByTaxIDRepository {

    BankAccountEntity findBankAccountByTaxID(String taxID);

}
