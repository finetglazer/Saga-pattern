// File: src/main/java/com/project/restaurantorderservice/core/SimpleSagaManager.java
package com.project.restaurantorderservice.core;

/**
 * A simplified interface for saga management without Eventuate dependencies
 */
public interface SimpleSagaManager<T> {
    void create(T sagaData);
}