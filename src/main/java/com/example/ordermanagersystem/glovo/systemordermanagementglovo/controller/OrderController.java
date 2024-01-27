package com.example.ordermanagersystem.glovo.systemordermanagementglovo.controller;

import com.example.ordermanagersystem.glovo.systemordermanagementglovo.service.OrderService;
import com.example.ordermanagersystem.glovo.systemordermanagementglovo.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderManagementService;

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestParam int orderId) {
        if (orderId <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Order createdOrder = orderManagementService.createOrder(orderId);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Void> updateOrder(@PathVariable int orderId, @RequestBody Order updatedOrder) {
        if (orderId <= 0 || updatedOrder == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            orderManagementService.updateOrder(updatedOrder);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int orderId) {
        try {
            Optional<Order> existingOrder = Optional.ofNullable(orderManagementService.getOrderById(orderId));

            if (existingOrder.isPresent()) {
                orderManagementService.deleteOrder(existingOrder.get());
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
