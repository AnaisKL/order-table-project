package org.example.orderproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.example.orderproject")
public class OrderProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderProjectApplication.class, args);
    }

}
