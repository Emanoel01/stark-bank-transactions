package com.transactions.Invoice.infra.implementations.configuration;


import com.transactions.Invoice.infra.entities.StarkBankConfigurationEntity;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;

public interface StarkBankConfigurationRepository extends FirestoreReactiveRepository<StarkBankConfigurationEntity> {

}
