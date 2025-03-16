// File: src/main/java/com/project/restaurantorderservice/sagas/createorder/CreateOrderSagaState.java
package com.project.restaurantorderservice.sagas.createorder;

import com.project.restaurantorderservice.domain.OrderDetails;

public class CreateOrderSagaState {

    private Long orderId;
    private OrderDetails orderDetails;

    // Default constructor for serialization
    public CreateOrderSagaState() {}

    public CreateOrderSagaState(Long orderId, OrderDetails orderDetails) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
    }

    public Long getOrderId() {
        return orderId;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    // No methods that depend on other command classes
}