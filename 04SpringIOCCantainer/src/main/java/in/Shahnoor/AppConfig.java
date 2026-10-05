package in.Shahnoor;

import in.Shahnoor.payment.CardPayment;
import in.Shahnoor.payment.PaymentService;
import in.Shahnoor.payment.UPIPayment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // used to tell it is config class
@ComponentScan("in.Shahnoor") //used to scan Component annotation means scanning the classes & find which class has Component ANNOTATION
//ByDefault it search the file in which AppConfig is placed
public class AppConfig {

    @Bean //now spring will create User obj
    public User createUser(){
            return new User("Shaan",22);
    }

//    @Bean
    //@Primary
    //@Qualifier
//    public PaymentService upi(){
//        return new UPIPayment();
//    }

//    @Bean
    //@Qualifier
//    public PaymentService cardPay(){
//        return new CardPayment();
//    }
//
//    @Bean
//    public OrderService createOrderService(@Qualifier(upi)PaymentService paymentService){
//        return new OrderService(paymentService);
//    }
}
