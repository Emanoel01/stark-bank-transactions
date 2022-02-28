package com.transactions.Invoice.infra.implementations.bankAccount.firestone;

import com.transactions.Invoice.infra.entities.BankAccountEntity;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Mono;

public interface BankAccountFirestoneRepository extends FirestoreReactiveRepository<BankAccountEntity> {
    Mono<BankAccountEntity> findByTaxID(String taxID);
}
