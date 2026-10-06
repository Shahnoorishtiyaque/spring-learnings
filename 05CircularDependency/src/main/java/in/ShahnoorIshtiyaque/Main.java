package in.ShahnoorIshtiyaque;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main() {

        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);

        Orderservice order=context.getBean(Orderservice.class);
        order.orderPlaced();
    }


    //circular dependency--> OrderService & PaymentService Both depend on each-other
    // it is not a spring problem it will create by weong code writing
    //we should avoid circular dependency rathen that solving it by using fiels injection bcoz it is not a good coding practice

}
