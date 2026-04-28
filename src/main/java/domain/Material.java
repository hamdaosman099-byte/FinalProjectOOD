package main.java.domain;


public class Material {
    private String name;
    private double impactValue;
    private String recyclingCategory;
    private String recyclingInstruction;

    public Material(String name, double impactValue, String recyclingCategory, String recyclingInstruction) {
        this.name = name;
        this.impactValue = impactValue;
        this.recyclingCategory = recyclingCategory;
        this.recyclingInstruction = recyclingInstruction;
    }

    public String getRecyclingGuidance() {
        return recyclingInstruction;
    }
    
    public String getName() {
        return name;
    }
    
    public double getImpactValue() {
        return impactValue;
    }
    public String getRecyclingCatogory(){
        return recyclingCategory;
    }
}