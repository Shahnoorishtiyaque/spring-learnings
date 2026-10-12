package com.example.SpringBootCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
//                         @EnableAutoConfiguration
//                         @ComponentScan-->by-default scan the package in which main is placed same as spring core
//                         @SpringBootApplication(scanBasePackages=packageName)-->use to overcome from above problem
//we can create vbean inside main bcoz main is alos work as AppConfig class
