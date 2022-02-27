package com.transactions.Invoice.infra.implementations.bankAccount;

import com.transactions.Invoice.infra.entities.BankAccountEntity;
import com.transactions.Invoice.infra.protocols.bankAccount.FindBankAccountByTaxIDRepository;
import com.transactions.Invoice.main.config.classes.StartBankConfiguration;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankAccountRepository implements FindBankAccountByTaxIDRepository {

    @Autowired
    private StartBankConfiguration configuration;


    @Override
    public BankAccountEntity findBankAccountByTaxID(String taxID) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        BeanUtils.copyProperties(configuration, bankAccountEntity);
        return bankAccountEntity;
    }
}
