// File: src/main/java/com/project/restaurantorderservice/config/EventuateConfig.java
package com.project.restaurantorderservice.config;


import io.eventuate.tram.sagas.spring.orchestration.SagaOrchestratorConfiguration;
import io.eventuate.tram.sagas.spring.participant.SagaParticipantConfiguration;
import io.eventuate.tram.spring.commands.producer.TramCommandProducerConfiguration;
import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.spring.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        TramEventsPublisherConfiguration.class,
        TramMessageProducerJdbcConfiguration.class,
        TramCommandProducerConfiguration.class,
        // Using our custom placeholder instead of TramJdbcKafkaConfiguration
        TramJdbcKafkaConfiguration.class,
        SagaOrchestratorConfiguration.class,
        SagaParticipantConfiguration.class
})
public class EventuateConfig {
    // Configuration class using imports from Eventuate
}