package com.transactions.Invoice.presentation.dtos.base;

import lombok.Data;

import java.util.Date;

@Data
public class DiscountDTO {

    private Integer percentage;
    private Date due;

}
