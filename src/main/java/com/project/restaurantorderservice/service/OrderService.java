// File: src/main/java/com/project/restaurantorderservice/service/OrderService.java
package com.project.restaurantorderservice.service;

import com.project.restaurantorderservice.core.SimpleDomainEventPublisher;
import com.project.restaurantorderservice.core.SimpleSagaManager;
import com.project.restaurantorderservice.domain.Order;
import com.project.restaurantorderservice.domain.OrderDetails;
import com.project.restaurantorderservice.domain.OrderRepository;
import com.project.restaurantorderservice.events.OrderCreatedEvent;
import com.project.restaurantorderservice.exceptions.OrderNotFoundException;
import com.project.restaurantorderservice.sagas.createorder.CreateOrderSagaState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final SimpleSagaManager<CreateOrderSagaState> sagaManager;
    private final SimpleDomainEventPublisher eventPublisher;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        SimpleSagaManager<CreateOrderSagaState> sagaManager,
                        SimpleDomainEventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.sagaManager = sagaManager;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public Order createOrder(OrderDetails orderDetails) {
        // Create and persist the Order
        Order order = Order.createOrder(orderDetails);
        orderRepository.save(order);

        // Publish domain events
        eventPublisher.publish("Order", order.getId().toString(),
                new OrderCreatedEvent(order.getId()));

        // Create a saga instance to process the order
        CreateOrderSagaState sagaState =
                new CreateOrderSagaState(order.getId(), orderDetails);
        sagaManager.create(sagaState);

        return order;
    }

    @Transactional
    public void approveOrder(Long orderId) {
        Order order = findById(orderId);
        order.approve();
        orderRepository.save(order);
    }

    @Transactional
    public void rejectOrder(Long orderId) {
        Order order = findById(orderId);
        order.reject();
        orderRepository.save(order);
    }

    public Order findById(Long orderId) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        return orderOpt.orElseThrow(() -> new OrderNotFoundException(orderId));
    }
}