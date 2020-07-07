package com.mycafe.coffee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeOrderRequest {
    private String id;
    private CoffeeType type;
    private Map<String, Object> additionalParameters;
}

