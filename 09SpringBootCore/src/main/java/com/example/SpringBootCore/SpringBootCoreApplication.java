package com.example.SpringBootCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.example")
public class
SpringBootCoreApplication {

	public static void main(String[] args) {

       ApplicationContext context= SpringApplication.run(SpringBootCoreApplication.class, args);
       OrderService orderService=context.getBean(OrderService.class);


       }
    @Bean
    public UserService GetUserService(){
           return new UserService();
    }

}

//@SpringBootApplication-->@SpringBootConfiguration--> same as @Configuration
//                         @EnableAutoConfiguration-->use @Autoconfigure,@ConditionalOnClass(WegbClassA.class) means springBoot create beans by their-self
//                         @ComponentScan-->by-default scan the package in which main is placed same as spring core
//                         @SpringBootApplication(scanBasePackages=packageName)-->use to overcome from above problem
//we can create bean inside main bcoz main is alos work as AppConfig class


//@Autoconfigure--> make bean automatically
//@ConditionalOnClass(WebClassA.class)--> make bean when webClassA is present
// @ConditionalOnMissingBean--> use after @Bean mean when bean is missing then create

//Example code-->
//@AutoConfiguration
//@ConditionalOnClass(webClassA.class)
//class A{
//    @Bean
//    @ConditionalOnMissingBean
//    public webClassA getWebA{
//        return new webClassA
//    }
//}