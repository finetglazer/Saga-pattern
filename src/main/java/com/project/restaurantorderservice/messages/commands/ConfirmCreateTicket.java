package com.project.restaurantorderservice.messages.commands;

public class ConfirmCreateTicket {
    private Long ticketId;

    public ConfirmCreateTicket() {}

    public ConfirmCreateTicket(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
}