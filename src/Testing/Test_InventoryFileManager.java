
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
    private static final String TEST_FILE = "test_inventory.csv";
    private static final String BACKUP_FILE = "backup_inventory.csv";
    private InventoryFileManager fileManager;

    Product product1 = new Product(0, "Samsung", 1000.0, 50, "Smartphone", LocalDate.parse("2024-05-29"));
    Product product2 = new Product(1, "Shampoo", 1200.0, 60, "null", LocalDate.parse("2022-05-29"));
    Product product3 = new Product(2, "Chips", 10000.0, 10, null, null);

    @BeforeEach
    public void setUp() {
        fileManager = new InventoryFileManager(TEST_FILE);
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE));
        Files.deleteIfExists(Path.of(BACKUP_FILE));
    }

    @Test
    public void testWriteInventoryToFile() throws IOException {
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        fileManager.writeInventoryToFile(products);

        List<String> lines = Files.readAllLines(Path.of(TEST_FILE));
        assertEquals(2, lines.size());
        assertEquals("0,Samsung,1000.0,50,Smartphone,2024-05-29", lines.get(0));
        assertEquals("1,Shampoo,1200.0,60,null,2022-05-29", lines.get(1));
    }

    @Test
    public void testReadInventoryFromFile() throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("0,Samsung,1000.0,50,Smartphone,2024-05-29");
        lines.add("1,Shampoo,1200.0,60,null,2022-05-29");
        Files.write(Path.of(TEST_FILE), lines);

        List<Product> products = fileManager.readInventoryFromFile();

        assertEquals(2, products.size());
        assertEquals(product1.getId(), products.get(0).getId());
        assertEquals(product1.getName(), products.get(0).getName());
        assertEquals(product1.getPrice(), products.get(0).getPrice(), 0.01);
        assertEquals(product1.getQuantity(), products.get(0).getQuantity());
        assertEquals(product1.getType(), products.get(0).getType());
        assertEquals(product1.getExpiryDate(), products.get(0).getExpiryDate());

        assertEquals(product2.getId(), products.get(1).getId());
        assertEquals(product2.getName(), products.get(1).getName());
        assertEquals(product2.getPrice(), products.get(1).getPrice(), 0.01);
        assertEquals(product2.getQuantity(), products.get(1).getQuantity());
        assertEquals(product2.getType(), products.get(1).getType());
        assertEquals(product2.getExpiryDate(), products.get(1).getExpiryDate());
    }


    @Test
    public void testBackupInventory() throws IOException {
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        fileManager.writeInventoryToFile(products);
        fileManager.backupInventory(BACKUP_FILE);

        List<String> originalLines = Files.readAllLines(Path.of(TEST_FILE));
        List<String> backupLines = Files.readAllLines(Path.of(BACKUP_FILE));

        assertEquals(originalLines, backupLines);
    }
}
