package Testing;

 
import static org.junit.Assert.*;
import org.junit.Test;

import cse430.Product;
import cse430.ShoppingCart;

import java.util.Map;
public class Test_ShopingCart {


    ShoppingCart cart = new ShoppingCart();
    Product  product1=new Product(0, "samsung", 1000, 50, null, null);
    Product  product2=new Product(1, "shampo", 100, 60, null, null);
    Product  product3=new Product(2, "chips", 10000, 10, null, null);

   
    @Test
    public void testAddItem() {
        cart.addItem(product1, 3);
        cart.addItem(product2, 2);
        assertEquals(2, cart.getItems().size());
    }

    @Test
    public void testRemoveItem() {
        cart.addItem(product1, 5);
        cart.removeItem(product1, 2);
        assertEquals(3, (int) cart.getItems().get(product1));
    }

    @Test
    public void testCalculateTotalPrice() {
        cart.addItem(product1, 3);
        cart.addItem(product2, 2);
        assertEquals(3200.0, cart.calculateTotalPrice(), 0.01); // 3 * 1000 + 2 * 1200 = 5200
    }

    @Test
    public void testClear() {
        cart.addItem(product1, 5);
        cart.clear();
        assertTrue(cart.isEmpty());
    }

    @Test
    public void testApplyDiscount() {
        cart.addItem(product1, 3);
        cart.applyDiscount(10);
        assertEquals(900000.0, cart.calculateTotalPrice(), 0.01); // 3 * 1000 * (1 - 0.10) = 2700
    }

    @Test
    public void testGetTotalQuantity() {
        cart.addItem(product1, 3);
        cart.addItem(product2, 2);
        assertEquals(5, cart.getTotalQuantity());
    }

    @Test
    public void testContainsProduct() {
        cart.addItem(product1, 3);
        assertTrue(cart.containsProduct(product1));
        assertFalse(cart.containsProduct(product2));
    }

    @Test
    public void testGetItemsAboveThreshold() {
        cart.addItem(product1, 3);
        cart.addItem(product2, 2);
        Map<Product, Integer> itemsAboveThreshold = cart.getItemsAboveThreshold(3);
        assertEquals(0, itemsAboveThreshold.size());
    }

    @Test
    public void testUpdateQuantity() {
        cart.addItem(product1, 3);
        cart.updateQuantity(product1, 5);
        assertEquals(5, (int) cart.getItems().get(product1));
    }
}
