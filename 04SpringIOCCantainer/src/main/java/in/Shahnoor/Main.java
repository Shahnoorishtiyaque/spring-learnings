package in.Shahnoor;

//Open pom.xml to add dependency for IOC caitainer
// we want somethimg so that spring will handle/manage my objects so use IOC container
//objects inside IOC conatiner are called Beans
//we use Reflexion API to stire the meta data of any class so we create Class<classname> c1=classname.class
//Class<> is special type of class whicgh is use to refrence metadata of createdb class

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main() {
//        ApplicationContext is use  as IOC container in Spring framework
        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class); // passing the reflection of class AppConfig
//        AnnotationConfigApplicationContext() used for annotation based config

//        OrderService order= new OrderService();
        OrderService order=context.getBean(OrderService.class);
        order.placedOrder();
        User user=context.getBean(User.class);
        System.out.println(user.getName());
//        PaymentService payment=context.getBean(PaymentService.class);
//        payment.pay();
    }
}


//Types of dependency injectuion:-
//        1.Constructor injection
//        2.Setter Injection
//        3.field Injection