package in.ShahnoorIshtiyaque;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component("User")
public class UserService  implements BeanNameAware , ApplicationContextAware {
    public UserService() {
        System.out.println("UserService constructor called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is "+name);   //we dont call it spring framework called it and set the bean name
        //methods called by spring is called call back methods
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application Context name is " + applicationContext);
    }
}
