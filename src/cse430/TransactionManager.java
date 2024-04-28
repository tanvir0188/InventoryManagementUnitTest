package cse430;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private List<Transaction> transactions;

    public TransactionManager() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public boolean removeTransaction(Transaction transaction) {
        return transactions.remove(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getTotalRevenue() {
      
        double totalRevenue = 0.0;
        for (Transaction transaction : transactions) {
            if (transaction.isPositiveAmount()) {
                totalRevenue += transaction.getAmount();
            }
        }
        return totalRevenue;
    }

    public int getTotalTransactions() {
        return transactions.size();
    }

    public List<Transaction> getTransactionsByType(String type) {
        
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase(type)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public boolean hasTransaction(Transaction transaction) {
        return transactions.contains(transaction);
    }

    public void clearAllTransactions() {
        transactions.clear();
    }

    
    public double getTotalExpenses() {
        
        double totalExpenses = 0.0;
        for (Transaction transaction : transactions) {
            if (!transaction.isPositiveAmount()) {
                totalExpenses += Math.abs(transaction.getAmount());
            }
        }
        return totalExpenses;
    }

    public boolean hasRefundTransactions() {
        for (Transaction transaction : transactions) {
            if (transaction.getType().equalsIgnoreCase("refund")) {
                return true;
            }
        }
        return false;
    }

}
