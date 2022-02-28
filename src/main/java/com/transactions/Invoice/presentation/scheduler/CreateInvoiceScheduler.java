package com.transactions.Invoice.presentation.scheduler;
import com.transactions.Invoice.domain.models.Invoice;
import com.transactions.Invoice.domain.usecases.invoice.CreateInvoice;
import com.transactions.Invoice.utils.generators.CnpjGenerator;
import com.transactions.Invoice.utils.generators.NameGenerator;
import com.transactions.Invoice.utils.generators.ValueGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@EnableScheduling
public class CreateInvoiceScheduler {

    @Autowired
    private NameGenerator nameGenerator;

    @Autowired
    private CnpjGenerator cnpjGenerator;

    @Autowired
    private ValueGenerator valueGenerator;

    private final long SECOND = 1000;
    private final long MINUTE = SECOND * 60;
    private final long HOUR = MINUTE * 60;

    private CreateInvoice createInvoice;

    public CreateInvoiceScheduler (CreateInvoice createInvoice){
        this.createInvoice = createInvoice;
    }

    @Scheduled(fixedDelay = HOUR * 3)
    public void handle(){
      try {
          int MIN_INVOICES_QUANTITY = 8;
          int MAX_INVOICES_QUANTITY = 12;
          int qntyInvoicesToGenerate = new Random().nextInt((MAX_INVOICES_QUANTITY-MIN_INVOICES_QUANTITY)+1) + MIN_INVOICES_QUANTITY;

          for(int count = 0; count < qntyInvoicesToGenerate; count++){

              int amount = this.valueGenerator.generate();
              String name= this.nameGenerator.generate();
              String taxID = this.cnpjGenerator.generate();

              Invoice invoice = new Invoice();
              invoice.setAmount(amount);
              invoice.setTaxId(taxID);
              invoice.setName(name);

              Boolean resultCreateInvoice = this.createInvoice.create(invoice);

              if(!resultCreateInvoice) throw new Exception("INVOICE_NOT_CREATED");
          }
      }catch (Exception e){
          e.printStackTrace();
          this.handle();
      }
    }
}
