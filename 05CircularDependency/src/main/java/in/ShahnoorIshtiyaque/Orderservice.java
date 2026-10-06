package in.ShahnoorIshtiyaque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Orderservice {
    @Autowired
   private PaymentService payment;

    public void orderDetails(){
        System.out.println("Order Details");
    }
    public void orderPlaced(){
        payment.pay();
        System.out.println("Order placed");
//      call here to avoid circular dependency
        orderDetails();
    }
}
