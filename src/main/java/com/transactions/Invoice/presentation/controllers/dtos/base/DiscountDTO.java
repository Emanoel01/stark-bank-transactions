package com.transactions.Invoice.presentation.controllers.dtos.base;

import lombok.Data;

import java.util.Date;

@Data
public class DiscountDTO {

    private Integer percentage;
    private Date due;

}
