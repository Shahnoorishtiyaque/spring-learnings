package in.ShahnoorIshtiyaque;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main() {
        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order=context.getBean(OrderService.class); // object created once
        OrderService order2=context.getBean(OrderService.class); //take reference of the created one
        System.out.println(order==order2);
        OrderService order3=new OrderService();//create new obj

    }
}


//Bean scope--> 1.Singleton  2.Prototype
//Singleton(Eager initialization)-->one object creation per bean defination

//Prototype-->(Lazy initialization) whenever we do get.bean or want dependency injection  it will always provide new obj

//singleton-->use for Stateless obj
//Prototype-->usee for stateful obj
 //Other Scopes-->
//Request
//Session
//Application