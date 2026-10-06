package in.ShahnoorIshtiyaque;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy //or @Scope("Prototype")
public class OrderService {
    public OrderService() {
        System.out.println("OrderService created");
    }
}
