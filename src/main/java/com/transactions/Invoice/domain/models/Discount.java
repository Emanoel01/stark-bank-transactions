package com.transactions.Invoice.domain.models;

import lombok.Data;

import java.util.Date;

@Data
public class Discount {

    private Integer percentage;
    private Date due;

}
