package com.transactions.Invoice.presentation.dtos.invoice;

import com.transactions.Invoice.presentation.dtos.base.DescriptionDTO;
import com.transactions.Invoice.presentation.dtos.base.DiscountDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class InvoiceDTO {
    private String id;
    private String status;
    private Integer amount;
    private Integer nominalAmount;
    private Integer fineAmount;
    private Integer interestAmount;
    private Integer discountAmount;
    private Integer expiration;
    private ArrayList<DiscountDTO> discountDTOS;
    private ArrayList<DescriptionDTO> descriptionDTOS;
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
