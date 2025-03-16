// File: src/main/java/com/project/restaurantorderservice/core/SimpleDomainEventPublisherImpl.java
package com.project.restaurantorderservice.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Simple implementation that logs events instead of publishing them
 */
@Component
public class SimpleDomainEventPublisherImpl implements SimpleDomainEventPublisher {

    private static final Logger logger = LoggerFactory.getLogger(SimpleDomainEventPublisherImpl.class);

    @Override
    public void publish(String aggregateType, String aggregateId, Object event) {
        logger.info("EVENT PUBLISHED - Type: {}, ID: {}, Event: {}",
                aggregateType, aggregateId, event);
    }
}