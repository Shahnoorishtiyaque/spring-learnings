package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    private PaymentProperties paymentProperties;

    public PaymentGateway(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }

    public String getType() {
        return paymentProperties.getType();
    }


    public int getRetryCount() {
        return paymentProperties.getRetryCount();
    }


    public boolean isEnable() {
        return paymentProperties.isEnable();
    }


    public int getTimeout() {
        return paymentProperties.getTimeout();
    }
    public void print(){
        System.out.println(getType());
        System.out.println(getRetryCount());
        System.out.println(getTimeout());
        System.out.println(isEnable());
    }










    //    @Value("${paymentProperty.type:RazerPay}")    /*RazerPay-->Default value*/
//    private String type;
//
//    @Value("${paymentGateway.retryCount:3}")
//    private int retryCount;
//
//    public PaymentGateway(@Value("${paymentGateway.type}") String type,
//                          @Value("${paymentGateway.retryCount}") int retryCount) {
//        this.type = type;
//        this.retryCount = retryCount;
//    }
//

}

//@Value-->pass as an argument and use variable name which is present in application.properties

//here we use @Value for evwry variable which might be confusing so we use @ConfigurationProperties in different class