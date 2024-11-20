package com.example.demo.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @GetMapping("/notification-service")
    public Map<String, Object> getNotificationService() {
        // Sample product data
        List<Map<String, Object>> products = new ArrayList<>();

        // Adding sample products
        products.add(createProduct("1", 1));
        products.add(createProduct("3", 15));
        products.add(createProduct("34", 5));
        products.add(createProduct("344", 0));

        // Prepare response
        Map<String, Object> response = new HashMap<>();
        List<Map<String, Object>> notifications = new ArrayList<>();

        for (Map<String, Object> product : products) {
            int quantity = (int) product.get("quantity");
            if (quantity < 4) {
                notifications.add(createNotification((String) product.get("productId"), quantity));
            }
        }

        response.put("products", products);
        response.put("notifications", notifications);
        return response;
    }

    private Map<String, Object> createProduct(String productId, int quantity) {
        Map<String, Object> product = new HashMap<>();
        product.put("productId", productId);
        product.put("quantity", quantity);
        return product;
    }

    private Map<String, Object> createNotification(String productId, int quantity) {
        Map<String, Object> notification = new HashMap<>();
        notification.put("message", "Low stock for product ID: " + productId);
        notification.put("quantity", quantity);
        return notification;
    }
}
