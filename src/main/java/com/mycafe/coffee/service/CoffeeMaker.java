package com.mycafe.coffee.service;

import java.util.Map;

public interface CoffeeMaker {
    String makeCoffee(Map<String, Object> additionalRequest);
}
