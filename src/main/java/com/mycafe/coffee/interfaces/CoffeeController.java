package com.mycafe.coffee.interfaces;

import com.mycafe.coffee.model.CoffeeOrderRequest;
import com.mycafe.coffee.service.CoffeeMaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class CoffeeController {

    @PostMapping(value = "/coffees")
    public ResponseEntity<String> makeCoffee(@RequestBody CoffeeOrderRequest coffeeOrderRequest) {
        CoffeeMaker coffeeMakerService = coffeeOrderRequest.getType().getCoffeeMaker();
        return ok(coffeeMakerService.makeCoffee(coffeeOrderRequest.getAdditionalParameters()));
    }
}
