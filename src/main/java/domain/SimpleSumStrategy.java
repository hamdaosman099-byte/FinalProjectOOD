package main.java.domain;


public class SimpleSumStrategy implements ImpactStrategy {
    @Override
    public double calculateImpact(Product product) {
        double total = 0;
        for (Material m : product.getMaterials()) {
            total += m.getImpactValue();
        }
        return total;
    }
}