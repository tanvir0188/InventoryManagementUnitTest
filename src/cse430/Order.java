package cse430;


import java.util.HashMap;
import java.util.Map;


public class Order {
    private int orderId;
    private int customerId;
    private String orderDate;
    private String paymentMethod;
    private  OrderStatus status;
    private final Map<Product, Integer> products;
    
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

    public void setStatus(Object shipped) {
        this.status = (OrderStatus) shipped;
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

    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        products.put(product, products.getOrDefault(product, 0) + quantity);
    }

    public static class OrderStatus {

        public static OrderStatus SHIPPED ;
        public static OrderStatus DELIVERED;
        public static OrderStatus PENDING;
        public static OrderStatus PROCESSING;
        public static OrderStatus IN_PROGRESS;

        public OrderStatus() {
        }
    }


    

   
}


