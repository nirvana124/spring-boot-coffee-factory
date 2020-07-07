package com.mycafe.coffee.model;

import com.mycafe.coffee.service.CoffeeMaker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.InvalidParameterException;
import java.util.Map;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum CoffeeType {
    LATTE("latteMaker"),
    ESPRESSO("espressoMaker"),
    CAPPUCCINO("cappuccinoMaker");

    private String serviceName;

    private static CoffeeMakerFactory factory;

    public CoffeeMaker getCoffeeMaker() {
        return this.factory.getCoffeeMaker(this.serviceName);
    }

    /*
    * Just an example to create coffee type object based on input parameters as done in factory pattern.
    * */
    public static CoffeeType fromServiceName(String serviceName) {
        return Stream.of(values()).filter(coffeeType -> coffeeType.serviceName.equals(serviceName))
                .findFirst()
                .orElseThrow(() -> new InvalidParameterException("Invalid service name " + serviceName));
    }

    @Component
    static class CoffeeMakerFactory {

        private Map<String, CoffeeMaker> coffeeMakers;

        @Autowired
        public CoffeeMakerFactory(Map<String, CoffeeMaker> coffeeMakers) {
            this.coffeeMakers = coffeeMakers;
        }

        public CoffeeMaker getCoffeeMaker(String serviceName) {
            return coffeeMakers.get(serviceName);
        }

        /*
        * To initialize factory variable in CoffeeType enum.
        * */
        @PostConstruct
        public void initialize() {
            if (factory == null) {
                factory = this;
            }
        }
    }
}
