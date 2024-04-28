package cse430;

import java.util.ArrayList;
import java.util.List;

public class Supplier {
    private List<Product> productsSupplied;

    public Supplier(String name) {
        this.productsSupplied = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productsSupplied.add(product);
    }

    public boolean removeProduct(Product product) {
        return productsSupplied.remove(product);
    }

    public void updateProductPrice(Product product, double newPrice) {

        double currentPrice = product.getPrice();
        double priceDifference = newPrice - currentPrice;
        if (priceDifference > 0) {
            double percentageIncrease = (priceDifference / currentPrice) * 100;
            product.setPrice(newPrice);
            System.out.println("Product price updated. Price increased by " + percentageIncrease + "%");
        } else if (priceDifference < 0) {
            double percentageDecrease = (-priceDifference / currentPrice) * 100;
            product.setPrice(newPrice);
            System.out.println("Product price updated. Price decreased by " + percentageDecrease + "%");
        } else {
            System.out.println("New price is same as current price. No update needed.");
        }
    }

    public List<Product> getProductsSupplied() {
        return productsSupplied;
    }

    public int getTotalProductsSupplied() {
        return productsSupplied.size();
    }

    public void clearAllProducts() {
        productsSupplied.clear();
    }

    public double getTotalInventoryValue() {
        
        double totalValue = 0.0;
        for (Product product : productsSupplied) {
            totalValue += product.getPrice() * product.getQuantity();
        }
        return totalValue;
    }

    public boolean hasProduct(Product product) {
        return productsSupplied.contains(product);
    }

    
    public boolean hasExpiredProducts() {
        for (Product product : productsSupplied) {
            if (product.isExpired()) {
                return true;
            }
        }
        return false;
    }

   
    public void updateProductQuantity(Product product, int newQuantity) {
      
        if (newQuantity > product.getQuantity()) {
            int additionalQuantity = newQuantity - product.getQuantity();
            System.out.println("Adding " + additionalQuantity + " units to product " + product.getName());
            product.setQuantity(newQuantity);
        } else if (newQuantity < product.getQuantity()) {
            int removedQuantity = product.getQuantity() - newQuantity;
            System.out.println("Removing " + removedQuantity + " units from product " + product.getName());
            product.setQuantity(newQuantity);
        } else {
            System.out.println("New quantity is same as current quantity. No update needed.");
        }
    }
}
