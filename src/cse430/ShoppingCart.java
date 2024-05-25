package cse430;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items;
    private double discountPercentage;

    public ShoppingCart() {
        this.items = new HashMap<>();
        this.discountPercentage = 0.0; // No discount by default
    }

    public void addItem(Product product, int quantity) {
        if (items.containsKey(product)) {
            items.put(product, items.get(product) + quantity);
        } else {
            items.put(product, quantity);
        }
    }

    public void removeItem(Product product, int quantity) {
        if (items.containsKey(product)) {
            int updatedQuantity = items.get(product) - quantity;
            if (updatedQuantity <= 0) {
                items.remove(product);
            } else {
                items.put(product, updatedQuantity);
            }
        }
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        // Apply discount if any
        totalPrice = totalPrice * (1 - discountPercentage / 100);
        return totalPrice;
    }

    public void clear() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void applyDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (int quantity : items.values()) {
            totalQuantity += quantity;
        }
        return totalQuantity;
    }

    public boolean containsProduct(Product product) {
        return items.containsKey(product);
    }

    public Map<Product, Integer> getItemsAboveThreshold(int threshold) {
        Map<Product, Integer> itemsAboveThreshold = new HashMap<>();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            if (entry.getValue() > threshold) {
                itemsAboveThreshold.put(entry.getKey(), entry.getValue());
            }
        }
        return itemsAboveThreshold;
    }

    public void updateQuantity(Product product, int newQuantity) {
        if (items.containsKey(product)) {
            items.put(product, newQuantity);
        }
    }
}
