package com.transactions.Invoice.utils.hour;

public class Hour {

    public static final Long getHour(Integer quantity){
        long SECOND = 1000;
        long MINUTE = SECOND * 60;
        long HOUR = MINUTE * 60;

        return HOUR * quantity;
    }

}
