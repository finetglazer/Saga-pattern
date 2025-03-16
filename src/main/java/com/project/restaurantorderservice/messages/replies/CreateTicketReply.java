package com.project.restaurantorderservice.messages.replies;

public class CreateTicketReply {
    private Long ticketId;

    public CreateTicketReply() {}

    public CreateTicketReply(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getTicketId() {
        return ticketId;
    }
}