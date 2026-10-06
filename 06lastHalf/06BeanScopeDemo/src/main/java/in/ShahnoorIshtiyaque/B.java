package in.ShahnoorIshtiyaque;

import org.springframework.stereotype.Component;

@Component
public class B {


    private OrderService orderService;

    public B(OrderService orderservice) {
        this.orderService=orderservice;
    }

}
