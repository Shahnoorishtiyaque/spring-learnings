package in.Shahnoor.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary //we use it because PaymentService component is also avl in CardPayment and we give this class method priority
@Qualifier("UPI") //bean name uPIPayment
public class UPIPayment implements PaymentService{
    @Override
    public void pay(){
        System.out.println("Paying by UPI");
    }
}
