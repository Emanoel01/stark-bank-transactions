package com.transactions.Invoice.presentation.controllers.webhook;

import com.transactions.Invoice.domain.models.webhook.Invoice.WebhookInvoice;
import com.transactions.Invoice.domain.usecases.webhook.invoice.WebHookHandlerInvoice;
import com.transactions.Invoice.main.adapters.WebhookAdapt;
import com.transactions.Invoice.presentation.controllers.dtos.invoice.WebhookInvoiceDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private WebHookHandlerInvoice webHookHandlerInvoice;

    public WebhookController(WebHookHandlerInvoice webHookHandlerInvoice){this.webHookHandlerInvoice = webHookHandlerInvoice;}

    @PostMapping
    private ResponseEntity<?> handle(@RequestBody WebhookInvoiceDTO webhookDTO){
        try{
            WebhookInvoice webhook =  WebhookAdapt.adaptWebhookDTOToWebhookInvoice(webhookDTO);
            Boolean result = this.webHookHandlerInvoice.handle(webhook);

//            if(!result) throw  new Error("INTERNAL_SERVER_ERROR");

            return new ResponseEntity(null,HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            switch (e.getMessage()){
                default: return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR );
            }
        }
    }

    @GetMapping("/status")
    private ResponseEntity<?> status(){
        System.out.println("Entrou aqui");
        return new ResponseEntity<String>("ONLINE",HttpStatus.OK);
    }

}


