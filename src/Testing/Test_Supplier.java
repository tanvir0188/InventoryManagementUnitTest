package Testing;

 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cse430.Product;
import cse430.Supplier;

import static org.junit.jupiter.api.Assertions.*;

 
    public class Test_Supplier {

        Supplier supplier = new Supplier("Supplier1");
        Product product1 = new Product(1, "Laptop", 1000.0, 10, "Electronics", LocalDate.of(2023, 12, 31));
        Product product2 = new Product(2, "Phone", 500.0, 5, "Electronics", LocalDate.of(2024, 12, 31));
        Product product3 = new Product(3, "Tablet", 300.0, 15, "Electronics", LocalDate.of(2023, 6, 30));
    
        @Test
        public void testAddProduct() {
            supplier.addProduct(product1);
            supplier.addProduct(product2);
    
            // Check added products
            assertEquals(2, supplier.getProductsSupplied().size());
            assertTrue(supplier.getProductsSupplied().contains(product1));
            assertTrue(supplier.getProductsSupplied().contains(product2));
        }
    
        @Test
        public void testRemoveProduct() {
            supplier.addProduct(product1);
            supplier.addProduct(product2);
    
            // Remove existing product
            assertTrue(supplier.removeProduct(product1));
    
            // Attempt to remove non-existing product
            assertFalse(supplier.removeProduct(product3));
        }
    
        @Test
        public void testUpdateProductPriceIncrease() {
            supplier.addProduct(product1);
            supplier.updateProductPrice(product1, 1200.0);
    
            // Check if price increased
            assertEquals(1200.0, product1.getPrice(), 0.01);
        }
    
        @Test
        public void testUpdateProductPriceDecrease() {
            supplier.addProduct(product1);
            supplier.updateProductPrice(product1, 800.0);
    
            // Check if price decreased
            assertEquals(800.0, product1.getPrice(), 0.01);
        }
    
        @Test
        public void testUpdateProductPriceNoChange() {
            supplier.addProduct(product1);
            supplier.updateProductPrice(product1, 1000.0);
    
            // Check if price remains the same
            assertEquals(1000.0, product1.getPrice(), 0.01);
        }
    
        @Test
        public void testGetTotalProductsSupplied() {
            supplier.addProduct(product1);
            supplier.addProduct(product2);
    
            // Check total products supplied
            assertEquals(2, supplier.getTotalProductsSupplied());
        }
    
        @Test
        public void testClearAllProducts() {
            supplier.addProduct(product1);
            supplier.addProduct(product2);
    
            // Clear all products
            supplier.clearAllProducts();
            assertTrue(supplier.getProductsSupplied().isEmpty());
        }
    
        @Test
        public void testGetTotalInventoryValue() {
            supplier.addProduct(product1);
            supplier.addProduct(product2);
    
            // Calculate total inventory value
            double expectedValue = (product1.getPrice() * product1.getQuantity()) + (product2.getPrice() * product2.getQuantity());
            assertEquals(expectedValue, supplier.getTotalInventoryValue(), 0.01);
        }
    
        @Test
        public void testHasProduct() {
            supplier.addProduct(product1);
    
            // Check if product exists
            assertTrue(supplier.hasProduct(product1));
            assertFalse(supplier.hasProduct(product2));
        }
    
        @Test
        public void testHasExpiredProducts() {
            Product expiredProduct = new Product(3, "ExpiredItem", 100.0, 1, "Misc", LocalDate.of(2020, 1, 1));
            supplier.addProduct(expiredProduct);
    
            // Check if supplier has expired products
            assertTrue(supplier.hasExpiredProducts());
    
            supplier.removeProduct(expiredProduct);
            assertFalse(supplier.hasExpiredProducts());
        }
    
        @Test
        public void testUpdateProductQuantityIncrease() {
            supplier.addProduct(product1);
            supplier.updateProductQuantity(product1, 15);
    
            // Check if quantity increased
            assertEquals(15, product1.getQuantity());
        }
    
        @Test
        public void testUpdateProductQuantityDecrease() {
            supplier.addProduct(product1);
            supplier.updateProductQuantity(product1, 5);
    
            // Check if quantity decreased
            assertEquals(5, product1.getQuantity());
        }
    
        @Test
        public void testUpdateProductQuantityNoChange() {
            supplier.addProduct(product1);
            supplier.updateProductQuantity(product1, 10);
    
            // Check if quantity remains the same
            assertEquals(10, product1.getQuantity());
        }
    }