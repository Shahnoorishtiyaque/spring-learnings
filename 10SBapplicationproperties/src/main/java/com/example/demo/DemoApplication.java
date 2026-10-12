package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
/*	    ApplicationContext context= */SpringApplication.run(DemoApplication.class, args);
//        PaymentGateway paymentGateway=context.getBean(PaymentGateway.class);
//        paymentGateway.print();--> see DemoRunner

	}

}


//external files which provide values to java code(Configuration files)-->
//                    application.properties
//                    application.yaml
//                    environment variables
//                    command line argument
//                    system properties