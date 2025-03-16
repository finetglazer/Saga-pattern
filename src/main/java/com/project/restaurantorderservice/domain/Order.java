package com.project.restaurantorderservice.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    public enum OrderState {
        PENDING, APPROVED, REJECTED
    }

    @Id
    @GeneratedValue
    private Long id;

    private Long consumerId;
    private Long restaurantId;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    // Default constructor for JPA
    protected Order() {}

    public static Order createOrder(OrderDetails orderDetails) {
        Order order = new Order();
        order.consumerId = orderDetails.getConsumerId();
        order.restaurantId = orderDetails.getRestaurantId();
        order.state = OrderState.PENDING;
        return order;
    }

    public Long getId() {
        return id;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public OrderState getState() {
        return state;
    }

    public void approve() {
        this.state = OrderState.APPROVED;
    }

    public void reject() {
        this.state = OrderState.REJECTED;
    }
}
