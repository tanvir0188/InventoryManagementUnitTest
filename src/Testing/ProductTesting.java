package Testing;

import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDate;
import cse430.Product;

public class ProductTesting {

    @Test
    public void testCalculateTotalValue() {
      
        Product product = new Product(1, "TestProduct", 10.0, 5, "TestType", LocalDate.now().plusDays(10));
        
        assertEquals(50.0, product.calculateTotalValue(), 0.01);
    }

    @Test
    public void testIsExpired() {
        // Create a product with an expiry date in the past
        Product expiredProduct = new Product(2, "ExpiredProduct", 10.0, 5, "TestType", LocalDate.now().minusDays(1));
        assertTrue(expiredProduct.isExpired());

        // Create a product with an expiry date in the future
        Product nonExpiredProduct = new Product(3, "NonExpiredProduct", 10.0, 5, "TestType", LocalDate.now().plusDays(1));
        assertFalse(nonExpiredProduct.isExpired());
    }
}
