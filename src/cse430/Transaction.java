package cse430;

import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime dateTime;
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.dateTime = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        this.amount = amount;
    }

    public boolean isPositiveAmount() {
        return amount > 0;
    }

    public boolean isNegativeAmount() {
        return amount < 0;
    }

    public boolean isOfType(String type) {
        return this.type.equalsIgnoreCase(type);
    }

    public boolean isRecentTransaction() {
       
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneWeekAgo = now.minusDays(7);
        return dateTime.isAfter(oneWeekAgo);
    }

    public boolean isPastTransaction() {
       
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneWeekAgo = now.minusDays(7);
        return dateTime.isBefore(oneWeekAgo);
    }

    
    public boolean exceedsThreshold(double threshold) {
        return amount > threshold;
    }

    
    public boolean isFutureTransaction() {
        
        LocalDateTime now = LocalDateTime.now();
        return dateTime.isAfter(now);
    }

   
    public boolean isRefundTransaction() {
        return type.equalsIgnoreCase("refund");
    }

    
    public boolean isSpecificTransaction(String type, double amount) {
        return this.type.equalsIgnoreCase(type) && this.amount == amount;
    }
}
