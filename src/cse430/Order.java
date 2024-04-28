package cse430;

import java.util.HashMap;
import java.util.Map;

enum OrderStatus {
    PENDING,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED
}

public class Order {
    private int orderId;
    private int customerId;
    private String orderDate;
    private String paymentMethod;
    private OrderStatus status;
    private Map<Product, Integer> products;
    
    public Order(int orderId, int customerId, String orderDate, String paymentMethod) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.status = OrderStatus.PENDING; 
        this.products = new HashMap<>();
        
    }

    // Getters and Setters for Order attributes
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

   

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += product.getPrice() * quantity;
        }
        return totalPrice;
    }
   
}
