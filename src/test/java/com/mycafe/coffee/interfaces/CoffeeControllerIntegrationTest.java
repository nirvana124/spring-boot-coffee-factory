package com.mycafe.coffee.interfaces;

import com.mycafe.coffee.CoffeeFactoryApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = CoffeeFactoryApplication.class)
@AutoConfigureMockMvc
class CoffeeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_ordering_coffee_latte() throws Exception {
        this.mockMvc.perform(post("/coffees")
                .content("{\"id\":\"974546\",\"type\":\"LATTE\", \"additionalParameters\" : {\"Milk\":\"Zero fat\"}}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("latte"));
    }

    @Test
    public void test_ordering_coffee_espresso() throws Exception {
        this.mockMvc.perform(post("/coffees")
                .content("{\"id\":\"454546\",\"type\":\"ESPRESSO\", \"additionalParameters\" : {\"shots\":\"double\"}}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Espresso"));
    }

    @Test
    public void test_ordering_coffee_cappuccino() throws Exception {
        this.mockMvc.perform(post("/coffees")
                .content("{\"id\":\"454546\",\"type\":\"CAPPUCCINO\", \"additionalParameters\" : {\"flavour\":\"hazelnut\"}}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Cappuccino"));
    }

    @Test
    public void test_ordering_coffee_random() throws Exception {
        this.mockMvc.perform(post("/coffees")
                .content("{\"id\":\"454546\",\"type\":\"RANDOM\", \"additionalParameters\" : {\"flavour\":\"hazelnut\"}}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}