package in.ShahnoorIshtiyaque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class PaymentService{
//    @Autowired
//    private Orderservice orderService;


    public void pay() {
        System.out.println("Payment Done");

//        ye OrderService ki responsibility honi chahiye
//        orderService.orderDetails();
    }
}
