package cse430;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<Integer, Product> inventory;

    public Warehouse() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        Product existingProduct = inventory.get(product.getId());
        if (existingProduct != null) {
            existingProduct.setQuantity(existingProduct.getQuantity() + quantity);
        } else {
            inventory.put(product.getId(), product);
        }
    }

    public boolean removeProduct(Product product, int quantity) {
        Product existingProduct = inventory.get(product.getId());
        if (existingProduct != null) {
            int remainingQuantity = existingProduct.getQuantity() - quantity;
            if (remainingQuantity <= 0) {
                inventory.remove(product.getId());
            } else {
                existingProduct.setQuantity(remainingQuantity);
            }
            return true;
        }
        return false;
    }

    public int getAvailableQuantity(Product product) {
        Product existingProduct = inventory.get(product.getId());
        return (existingProduct != null) ? existingProduct.getQuantity() : 0;
    }

    public Map<Integer, Product> getInventory() {
        return inventory;
    }

    public double calculateInventoryValue() {
        double totalValue = 0.0;
        for (Product product : inventory.values()) {
            totalValue += product.getPrice() * product.getQuantity();
        }
        return totalValue;
    }

    public boolean containsExpensiveProducts(double thresholdPrice) {
        for (Product product : inventory.values()) {
            if (product.getPrice() >= thresholdPrice) {
                return true;
            }
        }
        return false;
    }

    
    public boolean updateProductPrice(int productId, double newPrice) {
        Product existingProduct = inventory.get(productId);
        if (existingProduct != null) {
            existingProduct.setPrice(newPrice);
            return true;
        }
        return false;
    }

    
    public int getTotalProductCategories() {
        return inventory.size();
    }
}
