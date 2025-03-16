// File: src/main/java/com/project/restaurantorderservice/config/OrderServiceConfiguration.java
package com.project.restaurantorderservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.project.restaurantorderservice.domain")
public class OrderServiceConfiguration {

    // Remove all @Bean methods for beans that are already annotated with
    // @Service or @Component in their respective classes

    // You can keep other configuration here that doesn't create bean definition conflicts
}