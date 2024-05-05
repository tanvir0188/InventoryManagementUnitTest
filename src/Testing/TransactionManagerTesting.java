package Testing;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import cse430.Transaction;
import cse430.TransactionManager;

public class TransactionManagerTesting {
    TransactionManager transactionManager = new TransactionManager();

    Transaction transaction1 = new Transaction("normal", 10000.0);
    Transaction transaction2 = new Transaction("refund", 5000.0);
    Transaction transaction3 = new Transaction("premium", 100000.0);
    Transaction transaction4 = new Transaction("atm", 3000.0);
    Transaction transaction5 = new Transaction("payment", 2000.0);

    @Test
    public void addTransactionTest() {
        transactionManager.addTransaction(transaction1);
        transactionManager.addTransaction(transaction2);
        transactionManager.addTransaction(transaction3);
        transactionManager.addTransaction(transaction4);
        transactionManager.addTransaction(transaction5);

        assertEquals(5, transactionManager.getTransactions().size());

        assertEquals(transaction1, transactionManager.getTransactions().get(0));
        assertEquals(transaction2, transactionManager.getTransactions().get(1));
        assertEquals(transaction3, transactionManager.getTransactions().get(2));
        assertEquals(transaction4, transactionManager.getTransactions().get(3));
        assertEquals(transaction5, transactionManager.getTransactions().get(4));
    }

    @Test
    public void removeTransactionTest() {
        transactionManager.addTransaction(transaction1);
        transactionManager.addTransaction(transaction2);
        transactionManager.addTransaction(transaction3);
        transactionManager.addTransaction(transaction4);
        transactionManager.addTransaction(transaction5);

        assertEquals(5, transactionManager.getTransactions().size());

        transactionManager.removeTransaction(transaction2);

        assertEquals(4, transactionManager.getTransactions().size());
        assertEquals(false, transactionManager.hasTransaction(transaction2));
    }

    @Test
    public void getTotalRevenueTest() {
        transactionManager.addTransaction(transaction1);
        transactionManager.addTransaction(transaction2);
        transactionManager.addTransaction(transaction3);
        transactionManager.addTransaction(transaction4);
        transactionManager.addTransaction(transaction5);
        Transaction transaction6 = new Transaction("payment", -2000.0);
        transactionManager.addTransaction(transaction6);

        assertEquals(120000.0, transactionManager.getTotalRevenue(), 0.001);
    }

    @Test
    public void getTotalTransactionsTest() {
        transactionManager.addTransaction(transaction1);
        transactionManager.addTransaction(transaction2);
        transactionManager.addTransaction(transaction3);
        transactionManager.addTransaction(transaction4);
        transactionManager.addTransaction(transaction5);

        assertEquals(5, transactionManager.getTotalTransactions());
    }

    @Test
    public void getTransactionsByTypeTest() {
        transactionManager.addTransaction(transaction1);
        transactionManager.addTransaction(transaction2);
        transactionManager.addTransaction(transaction3);
        transactionManager.addTransaction(transaction4);
        transactionManager.addTransaction(transaction5);

        List<Transaction> premiumTransactions = transactionManager.getTransactionsByType("premium");
        assertEquals(1, premiumTransactions.size());
        assertEquals(transaction3, premiumTransactions.get(0));

        List<Transaction> refundTransactions = transactionManager.getTransactionsByType("refund");
        assertEquals(1, refundTransactions.size());
        assertEquals(transaction2, refundTransactions.get(0));
    }

    @Test
    public void hasTransactionTest() {
        transactionManager.addTransaction(transaction1);
        transactionManager.addTransaction(transaction2);
        transactionManager.addTransaction(transaction3);
        transactionManager.addTransaction(transaction4);
        transactionManager.addTransaction(transaction5);

        assertEquals(true, transactionManager.hasTransaction(transaction1));
        assertEquals(false, transactionManager.hasTransaction(new Transaction("normal", 10000.0)));
    }

    @Test
    public void clearAllTransactionsTest() {
        transactionManager.addTransaction(transaction1);
        transactionManager.addTransaction(transaction2);
        transactionManager.addTransaction(transaction3);
        transactionManager.addTransaction(transaction4);
        transactionManager.addTransaction(transaction5);

        assertEquals(5, transactionManager.getTransactions().size());

        transactionManager.clearAllTransactions();

        assertEquals(0, transactionManager.getTransactions().size());
    }

    @Test
    public void getTotalExpensesTest() {
        transactionManager.addTransaction(new Transaction("normal", -10000.0));
        transactionManager.addTransaction(new Transaction("normal", -5000.0));
        transactionManager.addTransaction(new Transaction("normal", -10000.0));

        assertEquals(25000.0, transactionManager.getTotalExpenses(), 0.001);
    }

    @Test
    public void hasRefundTransactionsTest() {
        transactionManager.addTransaction(transaction1);
        transactionManager.addTransaction(transaction2);
        transactionManager.addTransaction(transaction3);
        transactionManager.addTransaction(transaction4);
        transactionManager.addTransaction(transaction5);

        assertEquals(true, transactionManager.hasRefundTransactions());

        transactionManager.removeTransaction(transaction2);
        assertEquals(false, transactionManager.hasRefundTransactions());

    }

}
