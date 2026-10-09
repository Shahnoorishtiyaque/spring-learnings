package in.ShahnoorIshtiyaque;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//@Component
public class PaymentService {
    PaymentService(){
        System.out.println("PaymentService created");
    }
    public void pay(){
        System.out.println("Payment Successful");
    }
}
