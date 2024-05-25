package Testing;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


import cse430.Order;
import cse430.Order.OrderStatus;
import cse430.Product;

public class OrderTesting {
    
    Order Odr = new Order(1, 101, "2024-05-01", "Credit Card");
    Product prod1 = new Product(1, "Kitkat", 10.0, 2, null, null); 
    Product prod2 = new Product(2, "Safary", 20.0, 3, null, null); 
    OrderStatus od=new OrderStatus();
    

@Test
public void testOrder(){
    
    assertEquals(1,Odr.getOrderId());
    assertEquals(101,Odr.getCustomerId());
    assertEquals("2024-05-01",Odr.getOrderDate());
    assertEquals("Credit Card",Odr.getPaymentMethod());
    
}

@Test
    public void testOrderId() {
        
        assertEquals(1, Odr.getOrderId());
        Odr.setOrderId(2);
        assertEquals(2, Odr.getOrderId());
    }

    @Test
    public void testCustomerId() {
        assertEquals(101, Odr.getCustomerId());
        Odr.setCustomerId(201);
        assertEquals(201, Odr.getCustomerId());
    }

    @Test
    public void testOrderDate() {
       assertEquals("2024-05-01", Odr.getOrderDate());
        Odr.setOrderDate("2024-05-10");
        assertEquals("2024-05-10", Odr.getOrderDate());
    }

    @Test
    public void testPaymentMethod() {
        assertEquals("Credit Card", Odr.getPaymentMethod());
        Odr.setPaymentMethod("Cash");
        assertEquals("Cash", Odr.getPaymentMethod());
    }

    @Test
    public void testStatus() {
        assertEquals(Order.OrderStatus.PENDING, Odr.getStatus());
        Odr.setStatus(Order.OrderStatus.PROCESSING);
        assertEquals(Order.OrderStatus.PROCESSING, Odr.getStatus());
    }

    @Test
    public void testGetTotalPriceWithOneProduct() {
        Odr.addProduct(prod1, 2);
        assertEquals(20.0, Odr.getTotalPrice(), 0.01);
    }

    @Test
    public void testGetTotalPriceWithMultipleProduct() {
        Odr.addProduct(prod1, 2); 
        Odr.addProduct(prod2, 3);
        assertEquals(80.0, Odr.getTotalPrice(), 0.01);
    }
    @Test
    public void testGetTotalPriceWithNoProduct() {
        assertEquals(0.0, Odr.getTotalPrice(), 0.01);
    }
}

