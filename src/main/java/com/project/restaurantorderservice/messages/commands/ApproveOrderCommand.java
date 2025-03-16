package com.project.restaurantorderservice.messages.commands;

public class ApproveOrderCommand {
    private Long orderId;

    // Default constructor required for deserialization
    public ApproveOrderCommand() {}

    public ApproveOrderCommand(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }
}