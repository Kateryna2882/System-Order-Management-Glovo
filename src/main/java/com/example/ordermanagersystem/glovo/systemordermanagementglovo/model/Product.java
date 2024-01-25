package com.example.ordermanagersystem.glovo.systemordermanagementglovo.model;

public class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
        public void displayProductInfo() {
            System.out.println("Product: " + name);
            System.out.println("Price: $" + price);
        }
    }
