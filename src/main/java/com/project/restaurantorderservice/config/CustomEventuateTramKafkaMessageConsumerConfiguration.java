package com.project.restaurantorderservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({TramConsumerJdbcConfiguration.class})
public class CustomEventuateTramKafkaMessageConsumerConfiguration {
    // This is a simplified replacement for EventuateTramKafkaMessageConsumerConfiguration
    // that was missing in the dependency
}