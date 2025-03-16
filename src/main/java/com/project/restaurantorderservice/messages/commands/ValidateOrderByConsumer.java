package com.project.restaurantorderservice.messages.commands;

public class ValidateOrderByConsumer {
    private Long orderId;
    private Long consumerId;

    // Default constructor required for deserialization
    public ValidateOrderByConsumer() {}

    public ValidateOrderByConsumer(Long orderId, Long consumerId) {
        this.orderId = orderId;
        this.consumerId = consumerId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getConsumerId() {
        return consumerId;
    }
}