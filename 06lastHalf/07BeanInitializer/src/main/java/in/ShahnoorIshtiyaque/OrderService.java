package in.ShahnoorIshtiyaque;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
//@Lazy //or @Scope("Prototype")
public class OrderService {
    PaymentService payment;
    public OrderService(@Lazy PaymentService payment) {  //we pass dependency as proxy
        this.payment=payment;
        System.out.println("OrderService is created");
    }
}
