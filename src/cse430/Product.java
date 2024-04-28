package cse430;

import java.time.LocalDate;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String type;
    private LocalDate expiryDate; 

    public Product(int id, String name, double price, int quantity, String type, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.expiryDate = expiryDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    public double calculateTotalValue() {
        return price * quantity;
    }
}


