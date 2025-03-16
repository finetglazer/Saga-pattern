package com.project.restaurantorderservice.messages.commands;

import java.util.List;

public class CreateTicket {
    private Long restaurantId;
    private Long orderId;
    private TicketDetails ticketDetails;

    public CreateTicket() {}

    public CreateTicket(Long restaurantId, Long orderId, TicketDetails ticketDetails) {
        this.restaurantId = restaurantId;
        this.orderId = orderId;
        this.ticketDetails = ticketDetails;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public TicketDetails getTicketDetails() {
        return ticketDetails;
    }
}