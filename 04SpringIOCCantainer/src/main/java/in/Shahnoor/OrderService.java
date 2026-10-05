package in.Shahnoor;

import in.Shahnoor.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //it is used when we tell Spring to manage the obj of the following class
public class OrderService {
//    @Autowired
    private PaymentService paymentService;
    //Field Injection-> it is not recommended

    @Autowired  //wired the object of the PaymentService without passing by main
    public OrderService(@Qualifier("cardPayment") PaymentService paymentService){ //give Priority to CardPayment
        this.paymentService=paymentService;
        //constructor Injection-> this is recommended because it wired the dependencies during obj creation & final keyword can be used with PaymentService obj creation
//        if we have only one constructor then don't need to write @Autowired
    }

//    @Autowired
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//        //Setter Injection-> it wire dependencies after object creation
//    }

    public void placedOrder(){
        paymentService.pay();
        System.out.println("Order Placed");
 }


}
