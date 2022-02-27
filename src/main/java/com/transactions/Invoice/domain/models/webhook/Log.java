package com.transactions.Invoice.domain.models.webhook;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class Log {

    private String id;
    private Date created;
    private ArrayList<String> erros;
    private String type;

}
