package Testing;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.*;
import cse430.Customer;
import cse430.Product;
public class CustomerTesting {
Customer cs =new Customer(1, "Arifin", "arifinzaman", "dfndj");
Product  product=new Product(0, "samsung", 1000, 50, null, null);
Product  productTwo=new Product(0, "shampo", 100, 50, null, null);
@Test
public void testPurchaseItem() {
   
    
    cs.purchaseItem(product, 3);
    cs.purchaseItem(productTwo, 5);
    // Assert that the product is added to purchasedItems
    assertTrue(cs.hasPurchasedItem(product));
    assertTrue(cs.hasPurchasedItem(productTwo));

}
@Test
public void testGetTotalAmount_Purchase()
{
    cs.purchaseItem(product, 3);
    //without discount
    assertEquals(3000.0, cs.getTotalAmountSpent(), 0.001);
    cs.clearAllPurchasedItems();
    cs.purchaseItem(product, 10);
    //with discount test
    assertEquals(9000, cs.getTotalAmountSpent(), 0.001);
}
@Test
public void testPurchaseItem_Quantity() {
   
    
    cs.purchaseItem(product, 11);
    cs.purchaseItem(productTwo, 5);
    assertEquals(11, cs.getPurchasedItems().get(product).intValue());
    assertEquals(5, cs.getPurchasedItems().get(productTwo).intValue());
    
}

@Test
public void testReturnItem() {
   
    cs.purchaseItem(product, 5);
   cs.returnItem(product,2);
   assertEquals(3,cs.getTotalItemsPurchased());
   // Edge case: Trying to return more items than purchased
   cs.returnItem(product, 5);
   assertEquals(0,cs.getTotalItemsPurchased());
}
@Test
public void testClearItem() {
   
    int quantity = 5;
    cs.purchaseItem(product, quantity);
   cs.clearAllPurchasedItems();
  
   assertFalse(cs.hasPurchasedItem(product));
}
@Test
public void testHasMultipleItem() {
   
    int quantity =5 ;
    cs.purchaseItem(product, quantity);
    cs.purchaseItem(productTwo, quantity);
    assertTrue(cs.hasPurchasedMultipleItems());
    cs.clearAllPurchasedItems();
    cs.purchaseItem(product, quantity);
    assertFalse(cs.hasPurchasedMultipleItems());
}
@Test
public void testFrequentShopper() {
   
    int quantity =5 ;
    cs.purchaseItem(product, quantity);
    cs.purchaseItem(productTwo, quantity);
 
    assertFalse(cs.isFrequentShopper());
}
@Test
public void testAvgPurQuantity() {
   
    int quantity =5 ;
    cs.purchaseItem(product, quantity);
    cs.purchaseItem(productTwo, quantity);
    assertEquals(5.0, cs.calculateAveragePurchaseQuantity(), 0.001);
    cs.clearAllPurchasedItems();
    
     quantity =1 ;
    cs.purchaseItem(product, quantity);
    cs.purchaseItem(productTwo, quantity);
    assertEquals(1.0, cs.calculateAveragePurchaseQuantity(), 0.001);

    cs.clearAllPurchasedItems();
    
    quantity =5 ;
    cs.purchaseItem(product, quantity);
    assertEquals(5.0, cs.calculateAveragePurchaseQuantity(), 0.001);

}
@Test
public void testIsHighSpendingCustomer() {
   
    int quantity =5 ;
    cs.purchaseItem(product, quantity);
    cs.purchaseItem(productTwo, quantity);
 
    assertTrue(cs.hasHighSpending());

    cs.clearAllPurchasedItems();

     quantity =1 ;
  
    cs.purchaseItem(productTwo, quantity);
 
    assertFalse(cs.hasHighSpending());
}
@Test
public void testGetCustomerInfo(){
   
    assertEquals("dfndj",cs.getAddress());
    assertEquals("arifinzaman",cs.getEmail());
    assertEquals(0.0,cs.getBalance(),0.1);
    
    assertEquals(1.0,cs.getId(),0.1);
 
}
@Test
public void testAddBalance(){
   
    cs.addBalance(50000);
    assertEquals(50000.0,cs.getBalance(),0.1);

    

    cs.addBalance(10000);
    assertEquals(60000.0,cs.getBalance(),0.1);

}
@Test
public void testRemoveBalance()
{
    cs.addBalance(50000);
    cs.removeBalance(20000);
    assertEquals(30000.0,cs.getBalance(),0.1);
    cs.removeBalance(30000);
    assertEquals(0.0,cs.getBalance(),0.1);
}
}
