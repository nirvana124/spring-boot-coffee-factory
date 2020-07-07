package com.mycafe.coffee.factory;

import com.mycafe.coffee.model.CoffeeType;
import com.mycafe.coffee.service.CoffeeMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
/*
* If you don't want your enum as your factory.
*/
@Component
public class MyCafeCoffeeFactory {

    private Map<String, CoffeeMaker> coffeeMakers;

    @Autowired
    public MyCafeCoffeeFactory(Map<String, CoffeeMaker> coffeeMakers) {
        this.coffeeMakers = coffeeMakers;
    }

    public CoffeeMaker getCoffeeMaker(CoffeeType coffeeType) {
        return coffeeMakers.get(coffeeType.getServiceName());
    }
}
