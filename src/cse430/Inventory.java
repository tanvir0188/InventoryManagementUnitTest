package cse430;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public boolean removeProduct(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product findProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public List<Product> findProductsByName(String name) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public boolean updateProduct(int productId, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == productId) {
                products.set(i, updatedProduct);
                return true;
            }
        }
        return false;
    }

    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        List<Product> productsInRange = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                productsInRange.add(product);
            }
        }
        return productsInRange;
    }
    
    public double getTotalInventoryValue() {
        double totalValue = 0.0;
        for (Product product : products) {
            totalValue += product.getPrice() * product.getQuantity();
        }
        return totalValue;
    }

    public boolean checkProductAvailability(int productId, int quantity) {
        for (Product product : products) {
            if (product.getId() == productId && product.getQuantity() >= quantity) {
                return true;
            }
        }
        return false;
    }

    public double calculateAverageProductPrice() {
        if (products.isEmpty()) {
            return 0.0;
        }
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice / products.size();
    }


    public boolean hasProductType(String type) {
        for (Product product : products) {
            if (product.getType().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }

   
    public boolean updateProductQuantity(int productId, int newQuantity) {
        for (Product product : products) {
            if (product.getId() == productId) {
                product.setQuantity(newQuantity);
                return true;
            }
        }
        return false;
    }

    
    public void removeExpiredProducts() {
        List<Product> productsToRemove = new ArrayList<>();
        for (Product product : products) {
            if (product.isExpired()) {
                productsToRemove.add(product);
            }
        }
        products.removeAll(productsToRemove);
    }

   
    public List<Product> getProductsBelowThreshold(int threshold) {
        List<Product> belowThresholdProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getQuantity() < threshold) {
                belowThresholdProducts.add(product);
            }
        }
        return belowThresholdProducts;
    }
}

