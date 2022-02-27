package com.transactions.Invoice.infra.entities;

import com.transactions.Invoice.domain.models.Description;
import com.transactions.Invoice.domain.models.Discount;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class InvoiceEntity {
    private String id;
    private String status;
    private Integer amount;
    private Integer nominalAmount;
    private Integer fineAmount;
    private Integer interestAmount;
    private Integer discountAmount;
    private Integer expiration;
    private ArrayList<Discount> discounts;
    private ArrayList<Description> descriptions;
    private String name;
    private String taxId;
    private Integer fee;
    private String pdf;
    private Float fine;
    private Float interest;
    private ArrayList<String> tags;
    private String bcode;
    private Date created;
    private Date updated;
    private Date due;
}
