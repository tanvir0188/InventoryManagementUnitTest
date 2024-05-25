package Testing;

import static org.junit.Assert.*;
import org.junit.Test;

import cse430.Product;
import cse430.ShoppingCart;

import java.util.Map;

public class Test_ShopingCart {

    // Initialize a ShoppingCart instance for testing
    ShoppingCart cart = new ShoppingCart();
    // Sample products for testing
    Product product1 = new Product(0, "samsung", 1000, 10, "smartphone", null);
    Product product2 = new Product(1, "shampo", 100, 60,  "hairwash", null);
    Product product3 = new Product(2, "chips", 10000, 10, null, null);

    // Test adding items to the shopping cart
    @Test
    public void testAddItem() {
        // Add items to the cart
        cart.addItem(product1, 3);
        cart.addItem(product2, 2);
        // Assert that the number of items in the cart is as expected
        assertEquals(2, cart.getItems().size());
    }

    // Test removing items from the shopping cart
    @Test
    public void testRemoveItem() {
        // Add an item to the cart
        cart.addItem(product1, 5);
        // Remove some quantity of the item
        cart.removeItem(product1, 2);
        // Assert that the remaining quantity is as expected
        assertEquals(3, (int) cart.getItems().get(product1));
    }

    // Test calculating the total price of items in the cart
    @Test
    public void testCalculateTotalPrice() {
        // Add items to the cart
        cart.addItem(product1, 3);
        cart.addItem(product2, 2);
        // Assert that the total price is calculated correctly
        assertEquals(3200.0, cart.calculateTotalPrice(), 0.01); // 3 * 1000 + 2 * 100 = 3200
    }

    // Test clearing the shopping cart
    @Test
    public void testClear() {
        // Add an item to the cart
        cart.addItem(product1, 5);
        // Clear the cart
        cart.clear();
        // Assert that the cart is empty
        assertTrue(cart.isEmpty());
    }

    // Test applying a discount to the total price of items in the cart
    @Test
    public void testApplyDiscount() {
        // Add an item to the cart
        cart.addItem(product1, 3);
        // Apply a discount to the total price
        cart.applyDiscount(10); // 10% discount
         
        // Assert that the total price reflects the discount
        assertEquals(2700.0, cart.calculateTotalPrice(), 0.01); // 3 * 1000 * (1 - 0.10) = 2700
    }

    // Test getting the total quantity of items in the cart
    @Test
    public void testGetTotalQuantity() {
        // Add items to the cart
        cart.addItem(product1, 3);
        cart.addItem(product2, 2);
        // Assert that the total quantity is as expected
        assertEquals(5, cart.getTotalQuantity());
    }

    // Test checking if the cart contains a specific product
    @Test
    public void testContainsProduct() {
        // Add an item to the cart
        cart.addItem(product1, 3);
        // Assert that the cart contains the added product
        assertTrue(cart.containsProduct(product1));
        // Assert that the cart does not contain a product that was not added
        assertFalse(cart.containsProduct(product2));
    }

    // Test getting items above a specified quantity threshold
    @Test
    public void testGetItemsAboveThreshold() {
        // Add items to the cart
        cart.addItem(product1, 3);
        cart.addItem(product2, 2);
        // Get items with quantity above the threshold
        Map<Product, Integer> itemsAboveThreshold = cart.getItemsAboveThreshold(3);
        // Assert that no items are above the threshold
        assertEquals(0, itemsAboveThreshold.size());
    }

    // Test updating the quantity of an item in the cart
    @Test
    public void testUpdateQuantity() {
        // Add an item to the cart
        cart.addItem(product1, 3);
        // Update the quantity of the item
        cart.updateQuantity(product1, 5);
        // Assert that the updated quantity is as expected
        assertEquals(5, (int) cart.getItems().get(product1));
    }
}
