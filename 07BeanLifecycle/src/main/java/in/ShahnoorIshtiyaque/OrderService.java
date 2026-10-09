package in.ShahnoorIshtiyaque;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService payment;
    public OrderService(@Lazy PaymentService payment){
        this.payment=payment;
        System.out.println("OrderService created");
    }
    public void placeOrder(){
//        payment.pay();
        System.out.println("Order placed successfully!");
    }
}
