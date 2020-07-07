package com.mycafe.coffee.interfaces;

import com.mycafe.coffee.model.CoffeeOrderRequest;
import com.mycafe.coffee.service.CoffeeMaker;
import org.springframework.stereotype.Component;

@Component
public class CoffeeOrderEventListener {

    //    @SqsListener(value = "${com.enumfactory.command}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public String listen(CoffeeOrderRequest coffeeOrderRequest) {
        CoffeeMaker coffeeMaker = coffeeOrderRequest.getType().getCoffeeMaker();
        return coffeeMaker.makeCoffee(coffeeOrderRequest.getAdditionalParameters());
    }
}
