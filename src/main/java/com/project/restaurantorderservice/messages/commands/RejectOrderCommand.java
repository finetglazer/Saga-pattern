package com.project.restaurantorderservice.messages.commands;

public class RejectOrderCommand {
    private Long orderId;

    // Default constructor required for deserialization
    public RejectOrderCommand() {}

    public RejectOrderCommand(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }
}
