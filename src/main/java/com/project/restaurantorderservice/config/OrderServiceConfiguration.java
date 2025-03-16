// File: src/main/java/com/project/restaurantorderservice/config/OrderServiceConfiguration.java
package com.project.restaurantorderservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.project.restaurantorderservice.domain")
@EnableTransactionManagement
public class OrderServiceConfiguration {
    // Basic configuration only
}