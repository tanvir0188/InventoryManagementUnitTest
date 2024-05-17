package Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Duration;

import org.junit.Test;

import cse430.Transaction;

public class TransactionTesting {

    Transaction transaction = new Transaction("normal", 10000.0);
    Transaction transaction2 = new Transaction("refund", 10000.0);

    @Test
    public void constructorTesting() {
        assertEquals(10000.0, transaction.getAmount(), .001);
        LocalDateTime currentTime = LocalDateTime.now();
        Transaction transaction = new Transaction("normal", 10000.0);
        assertTrue(Duration.between(currentTime, transaction.getDateTime()).getSeconds() < 1);
        assertEquals("normal", transaction.getType());
    }

    @Test
    public void getterAndSetterTesting() {
        assertEquals(10000.0, transaction.getAmount(), .001);
        transaction.setAmount(20000.0);
        assertEquals(20000.0, transaction.getAmount(), .001);

        assertThrows(IllegalArgumentException.class, () -> {
            transaction.setAmount(-1000.0);
        });

        Transaction transaction1 = new Transaction("forDateTime", 10000.0);
        LocalDateTime currentTime = LocalDateTime.now();
        assertTrue(Duration.between(currentTime, transaction1.getDateTime()).getSeconds() < 1);

        assertEquals("normal", transaction.getType());
        assertEquals("forDateTime", transaction1.getType());

    }

    @Test
    public void isPositiveAmountTesting() {
        assertTrue(transaction.isPositiveAmount());
    }

    @Test
    public void isNegativeAmountTesting() {
        Transaction negativeTransaction = new Transaction("negative", -500.0);
        assertTrue(negativeTransaction.isNegativeAmount());
    }

    @Test
    public void isOfTypeTesting() {
        assertTrue(transaction.isOfType("normal"));
        assertFalse(transaction.isOfType("refund"));
    }

    @Test
    public void isRecentTransactionTesting() {
        assertTrue(transaction.isRecentTransaction());
    }

    @Test
    public void isPastTransactionTesting() {
        assertFalse(transaction.isPastTransaction());
        LocalDateTime eightDaysAgo = LocalDateTime.now().minusDays(8);
        Transaction oldTransaction = new Transaction("old", 500.0);
        oldTransaction.setDateTime(eightDaysAgo);
        assertTrue(oldTransaction.isPastTransaction());
    }

    @Test
    public void exceedsThresholdTesting() {
        assertTrue(transaction.exceedsThreshold(5000.0));
        assertFalse(transaction.exceedsThreshold(15000.0));
    }

    @Test
    public void isRefundTransactionTesting() {
        assertFalse(transaction.isRefundTransaction());
        Transaction refundTransaction = new Transaction("refund", 500.0);
        assertTrue(refundTransaction.isRefundTransaction());
    }

    @Test
    public void isSpecificTransactionTesting() {
        assertTrue(transaction.isSpecificTransaction("normal", 10000.0));
        assertFalse(transaction.isSpecificTransaction("normal", 5000.0));

        assertTrue(transaction2.isSpecificTransaction("refund", 10000.0));
        assertFalse(transaction2.isSpecificTransaction("normal", 5000.0));

    }

}