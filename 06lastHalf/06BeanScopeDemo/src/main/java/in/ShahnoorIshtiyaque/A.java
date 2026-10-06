package in.ShahnoorIshtiyaque;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class A {


    private OrderService orderService;

    public A(OrderService orderservice) {
        this.orderService=orderservice;
    }

}
