package com.project.restaurantorderservice.messages.commands;

public class AuthorizeCommand {
    private Long consumerId;
    private Long orderId;
    private double orderTotal;

    // Default constructor required for deserialization
    public AuthorizeCommand() {}

    public AuthorizeCommand(Long consumerId, Long orderId, double orderTotal) {
        this.consumerId = consumerId;
        this.orderId = orderId;
        this.orderTotal = orderTotal;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public double getOrderTotal() {
        return orderTotal;
    }
}