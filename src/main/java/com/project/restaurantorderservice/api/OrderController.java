// File: src/main/java/com/project/restaurantorderservice/api/OrderController.java
package com.project.restaurantorderservice.api;

import com.project.restaurantorderservice.domain.Order;
import com.project.restaurantorderservice.domain.OrderDetails;
import com.project.restaurantorderservice.exceptions.OrderNotFoundException;
import com.project.restaurantorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDetails orderDetails) {
        Order order = orderService.createOrder(orderDetails);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
        try {
            Order order = orderService.findById(orderId);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (OrderNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{orderId}/approve")
    public ResponseEntity<Void> approveOrder(@PathVariable Long orderId) {
        try {
            orderService.approveOrder(orderId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (OrderNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{orderId}/reject")
    public ResponseEntity<Void> rejectOrder(@PathVariable Long orderId) {
        try {
            orderService.rejectOrder(orderId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (OrderNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}