package cse430;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InventoryFileManager {
    private String fileName;

    public InventoryFileManager(String fileName) {
        this.fileName = fileName;
    }

    public void writeInventoryToFile(List<Product> products) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(fileName)))) {
            for (Product product : products) {
                writer.println(product.getId() + "," +
                                product.getName() + "," +
                                product.getPrice() + "," +
                                product.getQuantity() + "," +
                                product.getType() + "," + 
                                product.getExpiryDate()); 
            }
        }
    }

    public List<Product> readInventoryFromFile() throws IOException {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                String type = parts[4]; 
                LocalDate expiryDate = LocalDate.parse(parts[5]); 
                Product product = new Product(id, name, price, quantity, type, expiryDate);
                products.add(product);
            }
        }
        return products;
    }

    public void backupInventory(String backupFileName) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileName);
             FileOutputStream fos = new FileOutputStream(backupFileName)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        }
    }
}
