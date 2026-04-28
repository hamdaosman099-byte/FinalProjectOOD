package main.java.application;

import main.java.domain.Product;
import main.java.domain.Material;
import main.java.domain.ImpactStrategy;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products;
    private List<Material> materials;
    private ImpactStrategy strategy;

    public ProductService(ImpactStrategy strategy) {
        this.products = new ArrayList<>();
        this.materials = new ArrayList<>();
        this.strategy = strategy;
    }

    public void createProduct(String name, String category, int lifespan) {
        Product product = new Product(name, category, lifespan);
        products.add(product);
    }

    public void addMaterialToProduct(String productName, Material material) {
        Product product = findProductByName(productName);
        if (product != null) {
            product.addMaterial(material);
        }
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product findProductByName(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public double calculateProductImpact(Product product) {
        return strategy.calculateImpact(product);
    }

    public String getRecyclingGuidance(Product product) {
        if (product.getMaterials().isEmpty()) {
            return "Inga material tillagda ännu.";
        }
        StringBuilder guidance = new StringBuilder();
        for (Material m : product.getMaterials()) {
            guidance.append("- ").append(m.getName()).append(": ").append(m.getRecyclingGuidance()).append("\n");
        }
        return guidance.toString();
    }

    public void createMaterial(String name, double impactValue, String category, String instruction) {
        Material material = new Material(name, impactValue, category, instruction);
        materials.add(material);
    }

    public Material findMaterialByName(String name) {
        for (Material m : materials) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    public List<Material> getAllMaterials() {
        return materials;
    }

    public void setStrategy(ImpactStrategy strategy) {
        this.strategy = strategy;
    }
}