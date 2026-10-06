package in.ShahnoorIshtiyaque;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main{
    static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order=context.getBean(OrderService.class);//we need to create it for bean creation in Lazy

    }
}

//initialization-->
//1.Eager(By-default & can be Lazy)--> when IOC container is up-->Both object created even if we don't define it;
//2.Lazy(By-default Lazy  & cant be Eager)--> object created whenever they are wanted