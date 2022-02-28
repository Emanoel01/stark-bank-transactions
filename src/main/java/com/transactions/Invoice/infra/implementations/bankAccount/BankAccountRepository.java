package com.transactions.Invoice.infra.implementations.bankAccount;

import com.transactions.Invoice.infra.entities.BankAccountEntity;
import com.transactions.Invoice.infra.implementations.bankAccount.firestone.BankAccountFirestoneRepository;
import com.transactions.Invoice.infra.protocols.bankAccount.FindBankAccountByTaxIDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankAccountRepository implements FindBankAccountByTaxIDRepository {

    @Autowired
    private BankAccountFirestoneRepository firestoneRepository;


    @Override
    public BankAccountEntity findBankAccountByTaxID(String taxID) {
        BankAccountEntity bankAccountEntity = this.firestoneRepository.findByTaxID(taxID).block();
        return bankAccountEntity;
    }
}
