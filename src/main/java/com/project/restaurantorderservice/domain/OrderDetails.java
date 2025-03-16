package com.project.restaurantorderservice.domain;

import java.util.List;

public class OrderDetails {
    private Long consumerId;
    private Long restaurantId;
    private List<OrderLineItem> lineItems;
    private String deliveryAddress;

    public OrderDetails() {}

    public OrderDetails(Long consumerId, Long restaurantId,
                        List<OrderLineItem> lineItems, String deliveryAddress) {
        this.consumerId = consumerId;
        this.restaurantId = restaurantId;
        this.lineItems = lineItems;
        this.deliveryAddress = deliveryAddress;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public List<OrderLineItem> getLineItems() {
        return lineItems;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public static class OrderLineItem {
        private String menuItemId;
        private String name;
        private int quantity;
        private double price;

        public OrderLineItem() {}

        public OrderLineItem(String menuItemId, String name, int quantity, double price) {
            this.menuItemId = menuItemId;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        // Getters
        public String getMenuItemId() { return menuItemId; }
        public String getName() { return name; }
        public int getQuantity() { return quantity; }
        public double getPrice() { return price; }
    }
}