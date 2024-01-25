package com.example.ordermanagersystem.glovo.systemordermanagementglovo.service;
import com.example.ordermanagersystem.glovo.systemordermanagementglovo.model.Order;
import com.example.ordermanagersystem.glovo.systemordermanagementglovo.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders;

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

    }
    public void deleteOrder(Order order) {
        orders.remove(order);
    }

    public void addProductToOrder(Order order, Product product) {
        order.addProduct(product);
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
}