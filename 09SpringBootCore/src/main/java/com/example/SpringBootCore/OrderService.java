package com.example.SpringBootCore;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
    public OrderService() {
        System.out.println("OrderService created");
    }
    public void palceOrder(){
        System.out.println("Order placed successfully");
    }
}
