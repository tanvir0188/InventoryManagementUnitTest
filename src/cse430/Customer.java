package cse430;

import java.util.HashMap;
import java.util.Map;
enum CustomerStatus {
    REGULAR,
    PREMIUM,
    ACTIVE,
    INACTIVE
}
public class Customer {
	 private int id;
	    private String name;
	    private String email;
	    private String address;
	    private Map<Product, Integer> purchasedItems;
	    private double balance;
	    private CustomerStatus status;
	    public Customer(int id, String name, String email, String address) {
	    	 this.id = id;
	         this.name = name;
	         this.email = email;
	         this.address = address;
	         this.purchasedItems = new HashMap<>();
	         this.balance = 0.0;
	         this.status = CustomerStatus.REGULAR;
    }

    public void purchaseItem(Product product, int quantity) {
 
        double discountedPrice = applyDiscount(product.getPrice(), quantity);
        if (purchasedItems.containsKey(product)) {
            purchasedItems.put(product, purchasedItems.get(product) + quantity);
        } else {
            purchasedItems.put(product, quantity);
        }
        System.out.println(this.name + " purchased " + quantity + " of " + product.getName() + " for $" + discountedPrice * quantity);
    }

    private double applyDiscount(double price, int quantity) {
      
        double discount = 0.0;
        if (quantity >= 10) {
            discount = 0.1; // 10% discount for buying 10 or more items
        }
        return price * (1 - discount);
    }

    public void returnItem(Product product, int quantity) {
     
        if (purchasedItems.containsKey(product)) {
            int currentQuantity = purchasedItems.get(product);
            if (currentQuantity >= quantity) {
                purchasedItems.put(product, currentQuantity - quantity);
            } else {
                purchasedItems.remove(product);
            }
        }
        System.out.println(this.name + " returned " + quantity + " of " + product.getName());
    }

    public Map<Product, Integer> getPurchasedItems() {
        return purchasedItems;
    }

    public int getTotalItemsPurchased() {
        int total = 0;
        for (int quantity : purchasedItems.values()) {
            total += quantity;
        }
        return total;
    }

    public double getTotalAmountSpent() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : purchasedItems.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public boolean hasPurchasedItem(Product product) {
        return purchasedItems.containsKey(product);
    }

    public void clearAllPurchasedItems() {
        purchasedItems.clear();
    }

    public boolean hasPurchasedMultipleItems() {
        return purchasedItems.size() > 1;
    }

  
    public boolean isFrequentShopper() {
        return purchasedItems.size() >= 5; // Customer with 5 or more distinct purchased items is considered frequent
    }

  
    public double calculateAveragePurchaseQuantity() {
        int totalQuantity = 0;
        for (int quantity : purchasedItems.values()) {
            totalQuantity += quantity;
        }
        return (double) totalQuantity / purchasedItems.size();
    }

 
    public boolean hasHighSpending() {
        double totalSpending = getTotalAmountSpent();
        return totalSpending > 500; // Customer with spending over $500 is considered high spending
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

  
    public double getTotalPurchases() {
        double totalPurchases = 0.0;
        for (Map.Entry<Product, Integer> entry : purchasedItems.entrySet()) {
            totalPurchases += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPurchases;
    }

  
    public double getBalance() {
        return balance;
    }

  
    public CustomerStatus getStatus() {
        return status;
    }

  
    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

   
    public void addBalance(double amount) {
        balance += amount;
    }

    
    public void removeBalance(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    public boolean isActive() {
        return status == CustomerStatus.ACTIVE;
    }

}
