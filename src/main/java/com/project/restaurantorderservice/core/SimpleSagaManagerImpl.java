// File: src/main/java/com/project/restaurantorderservice/core/SimpleSagaManagerImpl.java
package com.project.restaurantorderservice.core;

import com.project.restaurantorderservice.sagas.createorder.CreateOrderSagaState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Simple implementation that logs saga creation instead of orchestrating it
 */
@Component
public class SimpleSagaManagerImpl implements SimpleSagaManager<CreateOrderSagaState> {

    private static final Logger logger = LoggerFactory.getLogger(SimpleSagaManagerImpl.class);

    @Override
    public void create(CreateOrderSagaState sagaData) {
        logger.info("SAGA CREATED - Order ID: {}", sagaData.getOrderId());

        // In a real implementation, this would start the saga process
        // For now, we'll just log it
        logger.info("MOCK SAGA: Validating order with consumer service");
        logger.info("MOCK SAGA: Creating ticket with kitchen service");
        logger.info("MOCK SAGA: Authorizing payment with accounting service");
        logger.info("MOCK SAGA: Approving order");
    }
}