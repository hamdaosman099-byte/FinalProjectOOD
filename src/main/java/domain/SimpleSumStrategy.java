package domain;

import java.util.List;

public class SimpleSumStrategy implements ImpactStrategy {

    @Override
    public double calculateImpact(Product product) {
        return sumMaterialImpact(product.getMaterials());
    }

    private double sumMaterialImpact(List<Material> materials) {
        double total = 0;
        for (Material m : materials) {
            total += m.getImpactValue();
        }
        return total;
    }
}