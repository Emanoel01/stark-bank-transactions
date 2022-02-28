package com.transactions.Invoice.presentation.dtos.base;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class LogDTO {

    private String id;
    private Date created;
    private ArrayList<String> erros;
    private String type;

}
