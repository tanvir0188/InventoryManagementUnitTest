package Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Duration;

import org.junit.Test;

import cse430.Transaction;

public class TransactionTesting {

    Transaction transaction = new Transaction("normal", 10000.0);

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

        Transaction transaction1 = new Transaction("forDateTime", 10000.0);
        LocalDateTime currentTime = LocalDateTime.now();
        assertTrue(Duration.between(currentTime, transaction1.getDateTime()).getSeconds() < 1);

        assertEquals("normal", transaction.getType());
        assertEquals("forDateTime", transaction1.getType());

    }

}