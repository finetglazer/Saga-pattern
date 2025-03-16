package com.project.restaurantorderservice.messages.commands;

public class TicketLineItem {
    private String menuItemId;
    private String name;
    private int quantity;

    public TicketLineItem() {}

    public TicketLineItem(String menuItemId, String name, int quantity) {
        this.menuItemId = menuItemId;
        this.name = name;
        this.quantity = quantity;
    }

    public String getMenuItemId() {
        return menuItemId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}