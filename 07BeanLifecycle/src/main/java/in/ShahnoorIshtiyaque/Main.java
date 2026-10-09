package in.ShahnoorIshtiyaque;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main() {
        ConfigurableApplicationContext /*to use close()*/ context= new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order=context.getBean(OrderService.class);
//        order.placeOrder();
//        UserService userService=context.getBean(UserService.class);
        //userService.setBeanName("newUserbean"); //it only use for print it cant change the real bean name
        CardService cardService=context.getBean(CardService.class);
        System.out.println(cardService.getValue(1));
        context.close();
    }
}


//steps in Bean cycle

//1.IOC container start - want bean class info so we pass AppConfig.class
//2.read configuration -
//3.Read Bean Definitions (create all)- BeanName:orderService
//                        beanClass:OrderService
//                        Scope:singleton
//                        Lazy:false
//                        dependency:paymentService
//4.Instantiate Objects-object creation
//5.dependencies Injected  4&5 both happens simultaneously when dependencies are injected through constructor
//6.aware Interfaces are called(see UserService)
//7.Initialization Callbacks(see cardService) - intermediate step between dependencies injection & method call
//                              1.InitializingBean
//                              2.init method
//                              3.Post Construct
//8.Bean is ready to use
//9.Destruction callback-
//                      1.DisposableBean
//                      2.destroyMethod
//                      3.Pre Destroy