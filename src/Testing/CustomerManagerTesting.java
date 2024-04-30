package Testing;
import cse430.CustomerManager;
import cse430.Product;
import cse430.Customer;
import cse430.Customer.CustomerStatus;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.*;

public class CustomerManagerTesting {
    CustomerManager csMan=new CustomerManager();
    Customer cs1 =new Customer(1, "Arifin", "arifinzaman", "khulna");
    Customer cs2 =new Customer(2, "farhan", "farhan@gmail.com", "rajshahi");
    Customer cs3 =new Customer(3, "tanvir", "tanvir@gmail.com", "dhaka");
    Customer cs4 =new Customer(4, "sumaya", "sumaya@gmail.com", "rangpur");
    Customer cs5 =new Customer(5, "Arnob", "Arnob@gmail.com", "pabna");

    Product  product=new Product(0, "samsung", 1000, 50, null, null);
    Product  productTwo=new Product(0, "shampo", 100, 50, null, null);

    @Test
    public void addCustomerTesting()
    {
        csMan.addCustomer(cs1);
        csMan.addCustomer(cs2);
        csMan.addCustomer(cs3);
        csMan.addCustomer(cs4);
        csMan.addCustomer(cs5);
        assertEquals(5,csMan.getTotalCustomers());
    }
    @Test
    public void findCustomerByIdTesting()
    {
        csMan.addCustomer(cs1);
        csMan.addCustomer(cs2);
        csMan.addCustomer(cs3);
        csMan.addCustomer(cs4);
        csMan.addCustomer(cs5);
       
        assertEquals("Arifin", csMan.findCustomerById(1).getName());
        
        assertEquals("farhan",csMan.findCustomerById(2).getName());
      
        assertEquals("tanvir",csMan.findCustomerById(3).getName());
        
        assertEquals("sumaya",csMan.findCustomerById(4).getName());
      
        assertEquals("Arnob",csMan.findCustomerById(5).getName());
    }
    @Test
    public void removeCustomerTesting()
    {
        csMan.addCustomer(cs1);
        csMan.addCustomer(cs2);
        csMan.addCustomer(cs3);
        csMan.addCustomer(cs4);
        csMan.addCustomer(cs5);

        csMan.removeCustomer(1);
        assertEquals(4,csMan.getTotalCustomers());
        csMan.removeCustomer(2);
        assertEquals(3,csMan.getTotalCustomers());
        csMan.removeCustomer(3);
        assertEquals(2,csMan.getTotalCustomers());
        csMan.removeCustomer(4);
        assertEquals(1,csMan.getTotalCustomers());
        csMan.removeCustomer(5);
        assertEquals(0,csMan.getTotalCustomers());
    }
    @Test
    public void updateEmailTesting()
    {
        csMan.addCustomer(cs1);
        csMan.addCustomer(cs2);
        csMan.addCustomer(cs3);
        csMan.addCustomer(cs4);
        csMan.addCustomer(cs5);

    

        assertTrue( csMan.updateCustomerEmail(1,"Ar@gmail.com"));
        
        assertTrue(csMan.updateCustomerEmail(2,"fr@gmail.com"));
      
        assertTrue(csMan.updateCustomerEmail(3,"tn@gmail.com"));
        
        assertTrue(csMan.updateCustomerEmail(4,"sm@gmail.com"));
      
        assertTrue(csMan.updateCustomerEmail(5,"ar@gmail.com"));

    }
    @Test
    public void updateAdressTesting()
    {
        csMan.addCustomer(cs1);
        csMan.addCustomer(cs2);
        csMan.addCustomer(cs3);
        csMan.addCustomer(cs4);
        csMan.addCustomer(cs5);

        assertTrue( csMan.updateCustomerAddress(1,"barisal"));
        
        assertTrue(csMan.updateCustomerAddress(2,"chittagong"));
      
        assertTrue(csMan.updateCustomerAddress(3,"rajshahi"));
        
        assertTrue(csMan.updateCustomerAddress(4,"khulna"));
      
        assertTrue(csMan.updateCustomerAddress(5,"sylet"));

    }
    @Test
    public void preferCustomerTesting()
    {
        csMan.addCustomer(cs1);
        csMan.addCustomer(cs2);
        csMan.addCustomer(cs3);
        csMan.addCustomer(cs4);
        csMan.addCustomer(cs5);

        int quantity = 3;
        cs1.purchaseItem(product, quantity);
        cs2.purchaseItem(productTwo, quantity);

        cs3.purchaseItem(product, quantity);

        cs4.purchaseItem(productTwo, quantity);

        cs5.purchaseItem(product, quantity);

        
        assertTrue(csMan.isPreferredCustomer(1));
        
        assertFalse(csMan.isPreferredCustomer(2));
      
        assertTrue(csMan.isPreferredCustomer(3));
        
        assertFalse(csMan.isPreferredCustomer(4));
      
        assertTrue(csMan.isPreferredCustomer(5));

    }
    @Test
    public void totalBalanceTesting()
    {
        csMan.addCustomer(cs1);
        csMan.addCustomer(cs2);
        csMan.addCustomer(cs3);
        csMan.addCustomer(cs4);
        csMan.addCustomer(cs5);

      
        cs1.addBalance(20000);
        cs2.addBalance(30000);

        cs3.addBalance(40000);

        cs4.addBalance(50000);

        cs5.addBalance(70000);

        
        assertEquals(210000.0,csMan.calculateTotalCustomerBalance(),0.001);


    }
    @Test
    public void highestSpendingCustomerTesting()
    {
        csMan.addCustomer(cs1);
        csMan.addCustomer(cs2);
        csMan.addCustomer(cs3);
        csMan.addCustomer(cs4);
        csMan.addCustomer(cs5);

      
        cs1.purchaseItem(product, 5);
        cs2.purchaseItem(productTwo, 10);

        cs3.purchaseItem(product, 3);

        cs4.purchaseItem(productTwo, 2);

        cs5.purchaseItem(product, 9);

        
        assertEquals("Arnob",csMan.findCustomerWithHighestPurchaseAmount().getName());


    }
    @Test
    public void updateCustomerStatusTesting()
    {
        csMan.addCustomer(cs1);
        csMan.addCustomer(cs2);
        csMan.addCustomer(cs3);
        csMan.addCustomer(cs4);
        csMan.addCustomer(cs5);

      
        cs1.purchaseItem(product, 5);
        cs2.purchaseItem(productTwo, 10);

        cs3.purchaseItem(product, 3);

        cs4.purchaseItem(productTwo, 2);

        cs5.purchaseItem(product, 9);

        csMan.updateCustomerStatus();

        assertEquals(CustomerStatus.PREMIUM, cs1.getStatus());
        assertEquals(CustomerStatus.PREMIUM, cs2.getStatus());
        assertEquals(CustomerStatus.PREMIUM, cs3.getStatus());
        assertEquals(CustomerStatus.REGULAR, cs4.getStatus());
        assertEquals(CustomerStatus.PREMIUM, cs5.getStatus());


    }
    @Test
public void calculateAveragePurchaseAmountTest() {
    csMan.addCustomer(cs1);
    csMan.addCustomer(cs2);
    csMan.addCustomer(cs3);
    csMan.addCustomer(cs4);
    csMan.addCustomer(cs5);

    cs1.purchaseItem(product, 5);
        cs2.purchaseItem(productTwo, 10);

        cs3.purchaseItem(product, 3);

        cs4.purchaseItem(productTwo, 2);

        cs5.purchaseItem(product, 9);

    // Call removeInactiveCustomers
    
    assertEquals(3640.0, csMan.calculateAveragePurchaseAmount(),0.001);

}
    }
