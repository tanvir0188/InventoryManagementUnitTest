package Testing;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import org.junit.Test;

import cse430.Inventory;
import cse430.Product;

 

public class Test_Inventory {

    Inventory inventory = new Inventory();
    Product  product1=new Product(0, "samsung", 1000, 50, "smartphone", LocalDate.parse("2024-05-29"));
    Product  product2=new Product(1, "shampo", 1200, 60, "null", LocalDate.parse("2022-05-29"));
    Product  product3=new Product(2, "chips", 10000, 10, null, null);

     
    @Test
    public void testAddProduct() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        //added 2 products chekh
        assertEquals(2, inventory.getProducts().size());
    }

    @Test
    public void testRemoveProduct() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        //added product remove true
        assertTrue(inventory.removeProduct(1));

        // not found product can not remove false
        assertFalse(inventory.removeProduct(3)); // Product with ID 3 does not exist
    }

    @Test
    public void testFindProductById() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        //find product with id
        assertEquals(product1, inventory.findProductById(0));
        // not faound id return null
        assertNull(inventory.findProductById(3)); // Product with ID 3 does not exist
    }

    @Test
    public void testFindProductsByName() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        //name in foundproducts to chekh how many name are there
        List<Product> foundProducts = inventory.findProductsByName("samsung");
        assertEquals(1, foundProducts.size());

        //rechakh for the product
        assertTrue(foundProducts.contains(product1)); // Check if product1 is found

        
    }

    @Test
    public void testUpdateProduct() {
        inventory.addProduct(product2);
        Product updatedProduct = new Product(1, "Samsung Galaxy S21 Ultra", 1200.0, 10,null, null); // Updated product
        
        // Update product
        assertTrue(inventory.updateProduct(1, updatedProduct));
        
        // Check if product is updated
        assertEquals(updatedProduct, inventory.findProductById(1));
        assertEquals("Samsung Galaxy S21 Ultra", inventory.findProductById(1).getName());
        assertEquals(10, inventory.findProductById(1).getQuantity());
    }

    @Test
    public void testGetProductsByPriceRange() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        //making a range object and chekhing how many are in that range
        List<Product> productsInRange = inventory.getProductsByPriceRange(1000.0, 1400.0);
        assertEquals(2, productsInRange.size());
    }

    
    @Test
    public void testGetTotalInventoryValue() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        //total ammount 
        assertEquals(122000.0, inventory.getTotalInventoryValue());
    }

    @Test
    public void testCheckProductAvailability() {
        inventory.addProduct(product2);

         // Enough quantity available
        assertTrue(inventory.checkProductAvailability(1, 40));

        // Not enough quantity available
        assertFalse(inventory.checkProductAvailability(1, 70)); 
    
 

    }

    @Test
    public void testCalculateAverageProductPrice() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        //inventory products (price /size)
        assertEquals(1100, inventory.calculateAverageProductPrice());
    }

    @Test
    public void testHasProductType() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        //this type of product available true
        assertTrue(inventory.hasProductType("Smartphone"));
        // this type of product is not available fase
        assertFalse(inventory.hasProductType("hairwash"));
    }

    @Test
    public void testUpdateProductQuantity() {
        inventory.addProduct(product2);
        assertTrue(inventory.updateProductQuantity(1, 70)); // Update quantity to 60

        //new quantity is equal
        assertEquals(70, inventory.findProductById(1).getQuantity());
    }

    @Test
    public void testRemoveExpiredProducts() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.removeExpiredProducts();
        assertEquals(0, inventory.findProductsByName("shampo").size()); // Expired shampo removed
    }

    @Test
    public void testGetProductsBelowThreshold() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);
        List<Product> belowThresholdProducts = inventory.getProductsBelowThreshold(20); // Threshold set to 20
        assertEquals(1, belowThresholdProducts.size()); // Only product2 has quantity below threshold
    }
    
}
