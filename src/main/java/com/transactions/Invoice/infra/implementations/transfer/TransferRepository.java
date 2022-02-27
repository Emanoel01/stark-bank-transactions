package com.transactions.Invoice.infra.implementations.transfer;

import com.starkbank.Transfer;
import com.transactions.Invoice.infra.entities.BankAccountEntity;
import com.transactions.Invoice.infra.entities.TransferEntity;
import com.transactions.Invoice.infra.protocols.transfer.CreateTransferRepository;
import com.transactions.Invoice.main.config.classes.StartBankConfiguration;
import com.transactions.Invoice.utils.enums.TRANSFER_STATUS;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Component
public class TransferRepository implements CreateTransferRepository {

    @Override
    public Boolean createTransfer(TransferEntity transferEntity, BankAccountEntity bankAccountEntity) throws Exception {
        List<Transfer> transfers = new ArrayList<>();
        HashMap<String, Object> data = new HashMap<>();
        data.put("amount", transferEntity.getAmount());
        data.put("bankCode", bankAccountEntity.getBankCode());
        data.put("branchCode", bankAccountEntity.getBranch());
        data.put("accountNumber", bankAccountEntity.getAccount());
        data.put("taxId", bankAccountEntity.getTaxID());
        data.put("name", bankAccountEntity.getName());
        data.put("externalId", UUID.randomUUID().toString());
//        data.put("tags", transferEntity.getTags());
//        System.out.println(data.get("externalId"));
        transfers.add(new Transfer(data));

        transfers = Transfer.create(transfers);

        for (Transfer transfer : transfers){
//            System.out.println(transfer);
            if(!transfer.status.toLowerCase().equals(TRANSFER_STATUS.CREATED)){
                return false;
            }
        }

        return true;
    }
}
