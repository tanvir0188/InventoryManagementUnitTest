package Testing;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cse430.Warehouse;
import cse430.Product;

public class WarehouseTesting {
    Warehouse wh = new Warehouse();

    Product prod1 = new Product(1, "diary", 300.0, 3, null, null); 
    Product prod2 = new Product(2, "pen", 100.0, 5, null, null); 



    @Test
    public void testAddOneProduct() {
            wh.addProduct(prod1, 3);
            assertEquals(1, wh.getInventory().size());
            assertEquals(3, wh.getAvailableQuantity(prod1));
         
    }
    

    @Test
    public void testAddMultipleProduct() {
        wh.addProduct(prod1, 3);
        wh.addProduct(prod2, 5);
        assertEquals(2, wh.getInventory().size());
        assertEquals(3, wh.getAvailableQuantity(prod1));
        assertEquals(5, wh.getAvailableQuantity(prod2));
    }

   @Test
    public void testRemoveOneProductQuantity() {
        wh.addProduct(prod1, 3);
        assertTrue(wh.removeProduct(prod1, 2));
        assertEquals(1, wh.getAvailableQuantity(prod1));

        assertTrue(wh.removeProduct(prod1, 3));
        assertEquals(0, wh.getAvailableQuantity(prod1));
        assertNull(wh.getInventory().get(prod1.getId()));
    }

    @Test
    public void testRemoveMultipleProductsQuantity() {
        wh.addProduct(prod1, 3);
        wh.addProduct(prod2, 5);
        assertTrue(wh.removeProduct(prod1, 2));
        assertTrue(wh.removeProduct(prod2, 3));
        
        assertEquals(1, wh.getAvailableQuantity(prod1));
        assertEquals(2, wh.getAvailableQuantity(prod2));
        
    }

    @Test
    public void testGetAvailableQuantity() {
        assertEquals(0, wh.getAvailableQuantity(prod1));
        wh.addProduct(prod1, 10);
        assertEquals(3, wh.getAvailableQuantity(prod1));
    }

    @Test
    public void testCalculateInventoryValue() {
        wh.addProduct(prod1, 10);
        wh.addProduct(prod2, 5);
        assertEquals(10* 100.0 + 4 * 100.0, wh.calculateInventoryValue(), 0.01);
    }
    @Test
    public void testCalculateInventoryValueEmpty() {
        assertEquals(0.0, wh.calculateInventoryValue(), 0.01);
    }
    @Test
    public void testCalculateInventoryValueAfterRemoveProduct() {
       
        wh.addProduct(prod1, 3); 
        wh.addProduct(prod2, 5); 

        wh.removeProduct(prod1, 3);
        assertEquals(5*100.0, wh.calculateInventoryValue(), 0.001);
    }

    @Test
    public void testContainsExpensiveProducts() {
        assertFalse(wh.containsExpensiveProducts(20));
        wh.addProduct(prod1, 10);
        assertTrue(wh.containsExpensiveProducts(5));
    }

    @Test
    public void testUpdateProductPriceForOneProduct() {
        wh.addProduct(prod1, 10);
        assertTrue(wh.updateProductPrice(1, 12.0));
        assertEquals(12.0, prod1.getPrice(), 0.01);
        
    }
    @Test
    public void testUpdateProductPriceForMultipleProduct() {
        wh.addProduct(prod1, 10);
        assertTrue(wh.updateProductPrice(1, 12.0));
        assertEquals(12.0, prod1.getPrice(), 0.01);
        assertFalse(wh.updateProductPrice(2, 20.0));
        assertEquals(100.0, prod2.getPrice(), 0.01);
        
    }
    @Test
    public void testGetTotalProductCategories() {
        assertEquals(0, wh.getTotalProductCategories());
    }
    @Test
    public void testGetTotalProductCategories_MultipleUniqueProducts() {
        wh.addProduct(prod1, 5);
        wh.addProduct(prod2, 3);
        assertEquals(2, wh.getTotalProductCategories());
    }
    @Test
    public void testGetTotalDuplicateProductCategories() {
        wh.addProduct(prod1, 5);
        wh.addProduct(prod2, 3);
        wh.addProduct(prod1, 2); 
        assertEquals(2, wh.getTotalProductCategories());
    }

}