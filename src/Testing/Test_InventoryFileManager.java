 package Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cse430.InventoryFileManager;
import cse430.Product;

public class Test_InventoryFileManager {
    // File names for testing purposes
    private static final String TEST_FILE = "test_inventory.csv";
    private static final String BACKUP_FILE = "backup_inventory.csv";
    // InventoryFileManager instance for testing
    private InventoryFileManager fileManager;

    // Sample products for testing
    Product product1 = new Product(0, "Samsung", 1000.0, 50, "Smartphone", LocalDate.parse("2024-05-29"));
    Product product2 = new Product(1, "Shampoo", 1200.0, 60, "null", LocalDate.parse("2022-05-29"));
    Product product3 = new Product(2, "Chips", 10000.0, 10, null, null);

    @BeforeEach
    public void setUp() {
        // Initialize InventoryFileManager before each test
        fileManager = new InventoryFileManager(TEST_FILE);
    }

    @AfterEach
    public void tearDown() throws IOException {
        // Clean up test files after each test
        Files.deleteIfExists(Path.of(TEST_FILE));
        Files.deleteIfExists(Path.of(BACKUP_FILE));
    }

    @Test
    public void testWriteInventoryToFile() throws IOException {
        // Create a list of products to write to the file
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        // Write the products to the file
        fileManager.writeInventoryToFile(products);

        // Read the contents of the file
        List<String> lines = Files.readAllLines(Path.of(TEST_FILE));
        
        // Check if the number of lines in the file is as expected
        assertEquals(2, lines.size());
        
        // Verify the contents of the file match the expected strings
        assertEquals("0,Samsung,1000.0,50,Smartphone,2024-05-29", lines.get(0));
        assertEquals("1,Shampoo,1200.0,60,null,2022-05-29", lines.get(1));
    }

    @Test
    public void testReadInventoryFromFile() throws IOException {
        // Create lines representing product data
        List<String> lines = new ArrayList<>();
        lines.add("0,Samsung,1000.0,50,Smartphone,2024-05-29");
        lines.add("1,Shampoo,1200.0,60,null,2022-05-29");
        
        // Write the lines to the test file
        Files.write(Path.of(TEST_FILE), lines);

        // Read the products from the file
        List<Product> products = fileManager.readInventoryFromFile();

        // Check if the number of products read is as expected
        assertEquals(2, products.size());
        
        // Verify the details of the first product match the expected values
        assertEquals(product1.getId(), products.get(0).getId());
        assertEquals(product1.getName(), products.get(0).getName());
        assertEquals(product1.getPrice(), products.get(0).getPrice(), 0.01);
        assertEquals(product1.getQuantity(), products.get(0).getQuantity());
        assertEquals(product1.getType(), products.get(0).getType());
        assertEquals(product1.getExpiryDate(), products.get(0).getExpiryDate());

        // Verify the details of the second product match the expected values
        assertEquals(product2.getId(), products.get(1).getId());
        assertEquals(product2.getName(), products.get(1).getName());
        assertEquals(product2.getPrice(), products.get(1).getPrice(), 0.01);
        assertEquals(product2.getQuantity(), products.get(1).getQuantity());
        assertEquals(product2.getType(), products.get(1).getType());
        assertEquals(product2.getExpiryDate(), products.get(1).getExpiryDate());
    }

    @Test
    public void testBackupInventory() throws IOException {
        // Create a list of products to write to the file
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        // Write the products to the original file
        fileManager.writeInventoryToFile(products);
        
        // Backup the original file
        fileManager.backupInventory(BACKUP_FILE);

        // Read the contents of the original file and the backup file
        List<String> originalLines = Files.readAllLines(Path.of(TEST_FILE));
        List<String> backupLines = Files.readAllLines(Path.of(BACKUP_FILE));

        // Verify that the contents of the original file and the backup file are the same
        assertEquals(originalLines, backupLines);
    }
}
