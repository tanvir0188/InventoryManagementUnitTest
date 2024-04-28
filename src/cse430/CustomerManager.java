package cse430;

import java.util.HashMap;
import java.util.Map;

public class CustomerManager {
    private Map<Integer, Customer> customers;

    public CustomerManager() {
        this.customers = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public boolean removeCustomer(int customerId) {
        return customers.remove(customerId) != null;
    }

    public Customer findCustomerById(int customerId) {
        return customers.get(customerId);
    }

    public boolean updateCustomerEmail(int customerId, String newEmail) {
        Customer customer = customers.get(customerId);
        if (customer != null) {
            customer.setEmail(newEmail);
            return true;
        }
        return false;
    }

    public boolean updateCustomerAddress(int customerId, String newAddress) {
        Customer customer = customers.get(customerId);
        if (customer != null) {
            customer.setAddress(newAddress);
            return true;
        }
        return false;
    }

    public int getTotalCustomers() {
        return customers.size();
    }

    public boolean isPreferredCustomer(int customerId) {
        Customer customer = customers.get(customerId);
        return customer != null && customer.getTotalPurchases() >= 1000;
    }

    public double calculateTotalCustomerBalance() {
        double totalBalance = 0.0;
        for (Customer customer : customers.values()) {
            totalBalance += customer.getBalance();
        }
        return totalBalance;
    }

 
    public Customer findCustomerWithHighestPurchaseAmount() {
        Customer highestSpendingCustomer = null;
        double maxPurchaseAmount = Double.MIN_VALUE;
        for (Customer customer : customers.values()) {
            if (customer.getTotalPurchases() > maxPurchaseAmount) {
                maxPurchaseAmount = customer.getTotalPurchases();
                highestSpendingCustomer = customer;
            }
        }
        return highestSpendingCustomer;
    }

   
    public void updateCustomerStatus() {
        for (Customer customer : customers.values()) {
            if (customer.getTotalPurchases() >= 500) {
                customer.setStatus(CustomerStatus.PREMIUM);
            } else {
                customer.setStatus(CustomerStatus.REGULAR);
            }
        }
    }

  
    public void removeInactiveCustomers() {
        for (Map.Entry<Integer, Customer> entry : customers.entrySet()) {
            if (!entry.getValue().isActive()) {
                customers.remove(entry.getKey());
            }
        }
    }

    
    public double calculateAveragePurchaseAmount() {
        if (customers.isEmpty()) {
            return 0.0;
        }

        double totalPurchaseAmount = 0.0;
        for (Customer customer : customers.values()) {
            totalPurchaseAmount += customer.getTotalPurchases();
        }

        return totalPurchaseAmount / customers.size();
    }
}

