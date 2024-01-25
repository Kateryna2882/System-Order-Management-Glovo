package com.example.ordermanagersystem.glovo.systemordermanagementglovo.controller;

import com.example.ordermanagersystem.glovo.systemordermanagementglovo.model.Order;
import com.example.ordermanagersystem.glovo.systemordermanagementglovo.model.Product;
import com.example.ordermanagersystem.glovo.systemordermanagementglovo.service.OrderService;

public class APIController {
    private final OrderService orderService;

    public APIController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Ендпоінт для отримання замовлення за його ID
    public Order getOrderById(int orderId) {
        return orderService.getOrderById(orderId);
    }

    // Ендпоінт для створення нового замовлення
    public Order createOrder(int orderId) {
        return orderService.createOrder(orderId);
    }

    // Ендпоінт для оновлення існуючого замовлення
    public void updateOrder(Order updatedOrder) {
        orderService.updateOrder(updatedOrder);
    }

    // Ендпоінт для видалення замовлення
    public void deleteOrder(Order order) {
        orderService.deleteOrder(order);
    }

    // Ендпоінт для додавання продукту до існуючого замовлення
    public void addProductToOrder(Order order, Product product) {
        orderService.addProductToOrder(order, product);
    }

    // Ендпоінт для видалення продукту з існуючого замовлення
    public void removeProductFromOrder(Order order, Product product) {
        orderService.removeProductFromOrder(order, product);
    }

    // Ендпоінт для виведення інформації про всі замовлення
    public void displayAllOrdersInfo() {
        orderService.displayAllOrdersInfo();
    }
}