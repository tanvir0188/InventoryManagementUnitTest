package cse430;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {
    private Map<Integer, Order> orders;

    public OrderManager() {
        this.orders = new HashMap<>();
    }

    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public boolean removeOrder(int orderId) {
        return orders.remove(orderId) != null;
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0.0;
        for (Order order : orders.values()) {
            totalRevenue += order.getTotalPrice();
        }
        return totalRevenue;
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        List<Order> ordersByCustomer = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getCustomerId() == customerId) {
                ordersByCustomer.add(order);
            }
        }
        return ordersByCustomer;
    }

    public int getTotalOrders() {
        return orders.size();
    }

    public void clearAllOrders() {
        orders.clear();
    }

    public Order findOrderById(int orderId) {
        return orders.get(orderId);
    }

    public boolean updateOrderStatus(int orderId, OrderStatus newStatus) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(newStatus);
            return true;
        }
        return false;
    }

    public List<Order> getOrdersWithStatus(OrderStatus status) {
        List<Order> ordersWithStatus = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getStatus() == status) {
                ordersWithStatus.add(order);
            }
        }
        return ordersWithStatus;
    }

  
    public List<Order> getOrdersByPaymentMethod(String paymentMethod) {
        List<Order> ordersByPaymentMethod = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getPaymentMethod().equalsIgnoreCase(paymentMethod)) {
                ordersByPaymentMethod.add(order);
            }
        }
        return ordersByPaymentMethod;
    }

 
    public List<Order> getOrdersByDateRange(String startDate, String endDate) {
        List<Order> ordersWithinDateRange = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getOrderDate().compareTo(startDate) >= 0 && order.getOrderDate().compareTo(endDate) <= 0) {
                ordersWithinDateRange.add(order);
            }
        }
        return ordersWithinDateRange;
    }

}
