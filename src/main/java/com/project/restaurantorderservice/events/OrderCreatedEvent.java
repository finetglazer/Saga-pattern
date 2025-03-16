package com.project.restaurantorderservice.events;

public class OrderCreatedEvent {
    private Long orderId;

    public OrderCreatedEvent() {}

    public OrderCreatedEvent(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }
}