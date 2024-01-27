package com.example.ordermanagersystem.glovo.systemordermanagementglovo.service;

import com.example.ordermanagersystem.glovo.systemordermanagementglovo.model.Order;
import com.example.ordermanagersystem.glovo.systemordermanagementglovo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderService {
    private final List<Order> orders;

    public OrderService() {
        this.orders = new ArrayList<>();
    }

    public Order createOrder(int orderId) {
        Order newOrder = new Order(orderId);
        orders.add(newOrder);
        return newOrder;
    }

    public Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public void updateOrder(Order updatedOrder) {
        int orderId = updatedOrder.getOrderId();
        Order existingOrder = getOrderById(orderId);

        if (existingOrder != null) {
            // Видаляємо старе замовлення
            orders.remove(existingOrder);

            // Додаємо оновлене замовлення
            orders.add(updatedOrder);
        } else {
            System.out.println("Order with ID " + orderId + " not found. Cannot update.");
        }
    }

    public void deleteOrder(Order order) {
        orders.remove(order);
    }


    public void removeProductFromOrder(Order order, Product product) {
        order.getProducts().remove(product);
    }

    public void displayAllOrdersInfo() {
        for (Order order : orders) {
            order.displayOrderInfo();
            System.out.println("---------------");
        }
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
    public void addProductToOrder(Order order, Product product) {
        if (order == null || product == null) {
            return;
        }

        order.addProduct(product);
    }

}

