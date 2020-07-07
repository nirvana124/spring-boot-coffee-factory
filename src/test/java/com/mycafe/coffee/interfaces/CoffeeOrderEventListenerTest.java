package com.mycafe.coffee.interfaces;

import com.mycafe.coffee.model.CoffeeType;
import com.mycafe.coffee.model.CoffeeOrderRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CoffeeOrderEventListenerTest {

    @Autowired
    private CoffeeOrderEventListener coffeeOrderEventListener;

    @Test
    void listenForEspresso() {
        String actual = coffeeOrderEventListener.listen(new CoffeeOrderRequest("123", CoffeeType.ESPRESSO, Collections.emptyMap()));
        assertEquals("Espresso", actual);
    }

    @Test
    void listenForCappuccino() {
        String actual = coffeeOrderEventListener.listen(new CoffeeOrderRequest("123", CoffeeType.CAPPUCCINO, Collections.emptyMap()));
        assertEquals("Cappuccino", actual);
    }

    @Test
    void listenForLatte() {
        String actual = coffeeOrderEventListener.listen(new CoffeeOrderRequest("123", CoffeeType.LATTE, Collections.singletonMap("Milk", "Cow")));
        assertEquals("latte", actual);
    }
}