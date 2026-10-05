package in.Shahnoor.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier //we have to add it on both the class it means both want to qualify Bean name-> cardPayment
public class CardPayment implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Paying via cards");
    }
}
