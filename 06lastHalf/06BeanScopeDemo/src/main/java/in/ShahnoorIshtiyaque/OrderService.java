package in.ShahnoorIshtiyaque;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton") //by-default
@Scope("prototype")
public class OrderService {
    public OrderService() {
        System.out.println("OrderSeavice created");
    }

    public void placedOrder(){
        System.out.println("Order placed");
    }
}
