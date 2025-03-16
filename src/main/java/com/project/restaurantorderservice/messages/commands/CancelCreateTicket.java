package com.project.restaurantorderservice.messages.commands;

public class CancelCreateTicket {
    private Long ticketId;

    public CancelCreateTicket() {}

    public CancelCreateTicket(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
}