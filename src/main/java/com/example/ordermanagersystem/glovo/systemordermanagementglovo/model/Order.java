package com.example.ordermanagersystem.glovo.systemordermanagementglovo.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<Product>products;

    public Order(int orderId){
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
    public int getOrderId() {
        return orderId;
    }
    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
    public void displayOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + ": $" + product.getPrice());
        }
        System.out.println("Total Price: $" + calculateTotalPrice());
    }
}
