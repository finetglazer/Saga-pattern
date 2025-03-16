// File: src/main/java/com/project/restaurantorderservice/RestaurantOrderServiceApplication.java
package com.project.restaurantorderservice;

import com.project.restaurantorderservice.config.OrderServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({OrderServiceConfiguration.class})
public class RestaurantOrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestaurantOrderServiceApplication.class, args);
    }
}