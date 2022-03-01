package com.transactions.Invoice.presentation.controllers.webhook;

import com.transactions.Invoice.domain.models.webhook.Invoice.WebhookInvoice;
import com.transactions.Invoice.domain.usecases.webhook.invoice.WebHookHandlerInvoice;
import com.transactions.Invoice.main.adapters.WebhookAdapt;
import com.transactions.Invoice.presentation.dtos.invoice.WebhookInvoiceDTO;
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
            if(!result) throw  new Exception("");
            return new ResponseEntity(null,HttpStatus.OK);
        }catch (Exception e){
            switch (e.getMessage()){
                case "BANK_ACCOUNT_NOT_FOUND":
                    return new ResponseEntity("Banck Account was not found!", HttpStatus.BAD_REQUEST );
                default:
                    return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR );
            }
        }
    }

    @GetMapping("/status")
    private ResponseEntity<?> status(){
//        System.out.println("teste");
        return new ResponseEntity<String>("ONLINE",HttpStatus.OK);
    }

}


