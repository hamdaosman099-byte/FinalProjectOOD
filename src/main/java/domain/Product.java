package main.java.domain;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private String category;
    private int estimatedLifespan;
    private List<Material> materials;

    public Product(String name, String category, int estimatedLifespan) {
        this.name = name;
        this.category = category;
        this.estimatedLifespan = estimatedLifespan;
        this.materials = new ArrayList<>();
    }

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public List<Material> getMaterials() {
        return materials;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCategory() {
        return category;
    }
    
    public int getEstimatedLifespan() {
        return estimatedLifespan;
    }
}