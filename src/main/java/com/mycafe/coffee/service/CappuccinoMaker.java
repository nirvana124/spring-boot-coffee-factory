package com.mycafe.coffee.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service("cappuccinoMaker")
public class CappuccinoMaker implements CoffeeMaker {


    @Override
    public String makeCoffee(Map<String, Object> additionalRequest) {
        System.out.println("Making Cappuccino" + additionalRequest);
        return "Cappuccino";
    }
}
