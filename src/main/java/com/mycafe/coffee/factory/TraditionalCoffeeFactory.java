package com.mycafe.coffee.factory;

import com.mycafe.coffee.model.CoffeeType;
import com.mycafe.coffee.service.CoffeeMaker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
/*
* Traditional way of implementing Factory design pattern.
* */
@Component
public class TraditionalCoffeeFactory {

    private CoffeeMaker latteMaker;
    private CoffeeMaker espressoMaker;
    private CoffeeMaker cappuccinoMaker;

    public TraditionalCoffeeFactory(@Qualifier("latteMaker") CoffeeMaker latteMaker,
                                    @Qualifier("espressoMaker") CoffeeMaker espressoMaker,
                                    @Qualifier("cappuccinoMaker") CoffeeMaker cappuccinoMaker) {
        this.latteMaker = latteMaker;
        this.espressoMaker = espressoMaker;
        this.cappuccinoMaker = cappuccinoMaker;
    }

    public CoffeeMaker coffeeMaker(CoffeeType coffeeType) {
        CoffeeMaker coffeeMaker = null;
        switch (coffeeType) {
            case LATTE:
                coffeeMaker = latteMaker;
                break;
            case ESPRESSO:
                coffeeMaker = espressoMaker;
                break;
            case CAPPUCCINO:
                coffeeMaker = cappuccinoMaker;
        }
        return coffeeMaker;
    }

}
