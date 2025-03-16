// File: src/main/java/com/project/restaurantorderservice/core/SimpleDomainEventPublisher.java
package com.project.restaurantorderservice.core;

/**
 * A simplified interface for publishing domain events without Eventuate dependencies
 */
public interface SimpleDomainEventPublisher {
    void publish(String aggregateType, String aggregateId, Object event);
}