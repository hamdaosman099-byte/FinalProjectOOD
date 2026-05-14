package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleSumStrategyTest {

    @Test
    void testCalculateImpact() {
        SimpleSumStrategy strategy = new SimpleSumStrategy();
        Product product = new Product("Telefon", "Elektronik", 5);

        product.addMaterial(new Material("Plast", 10, "Plastic", "Recycle"));
        product.addMaterial(new Material("Metall", 20, "Metal", "Reuse"));

        double result = strategy.calculateImpact(product);

        assertEquals(30, result);
    }

    @Test
    void testEmptyProduct() {
        SimpleSumStrategy strategy = new SimpleSumStrategy();
        Product product = new Product("Test", "None", 0);

        double result = strategy.calculateImpact(product);

        assertEquals(0, result);
    }

    @Test
    void testOneMaterial() {
        SimpleSumStrategy strategy = new SimpleSumStrategy();
        Product product = new Product("Test", "None", 1);

        product.addMaterial(new Material("Plast", 10, "Plastic", "Recycle"));

        double result = strategy.calculateImpact(product);

        assertEquals(10, result);
    }
}