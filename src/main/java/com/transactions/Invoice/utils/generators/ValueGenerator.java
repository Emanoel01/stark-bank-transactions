package com.transactions.Invoice.utils.generators;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ValueGenerator {

    public Integer generate(){
        Random random = new Random();
        return random.nextInt(10000000);
    }

}
