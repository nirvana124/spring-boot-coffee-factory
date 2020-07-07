package com.mycafe.coffee.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service("latteMaker")
public class LatteMaker implements CoffeeMaker {

    @Override
    public String makeCoffee(Map<String, Object> additionalRequest) {
        System.out.println("Making latte " + additionalRequest);
        return "latte";
    }
}
