package domain;


public class WeightedByLifespanStrategy implements ImpactStrategy {
    @Override
    public double calculateImpact(Product product) {
        double total = 0;
        for (Material m : product.getMaterials()) {
            double weight = 1.0;
            if (product.getEstimatedLifespan() < 2) {
                weight = 1.5;
            } else if (product.getEstimatedLifespan() > 10) {
                weight = 0.5;
            }
            total += m.getImpactValue() * weight;
        }
        return total;
    }
}