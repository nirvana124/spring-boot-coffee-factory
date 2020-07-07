package com.mycafe.coffee.service;


import org.springframework.stereotype.Service;

import java.util.Map;

@Service("espressoMaker")
public class EspressoMaker implements CoffeeMaker {

    @Override
    public String makeCoffee(Map<String, Object> additionalRequest) {
        System.out.println("Making Espresso" + additionalRequest);
        return "Espresso";
    }
}
