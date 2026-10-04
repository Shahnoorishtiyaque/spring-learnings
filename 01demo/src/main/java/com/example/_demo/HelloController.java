package com.example._demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("Hello")
    public String Hello(){ return "<h1>This is home page</h1>";}
}
