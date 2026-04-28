package main.java.presentation;


import main.java.application.ProductService;
import main.java.domain.Product;
import main.java.domain.Material;
import main.java.domain.SimpleSumStrategy;
import main.java.domain.WeightedByLifespanStrategy;

import java.util.Scanner;
import java.util.List;

public class ConsoleUI {
    private ProductService service;
    private Scanner scanner;

    public ConsoleUI() {
        this.service = new ProductService(new SimpleSumStrategy());
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = readChoice();
            handleChoice(choice);
        }
    }

    private void showMenu() {
        System.out.println("\n=== HÅLLBART PRODUKTSYSTEM ===");
        System.out.println("1. Skapa produkt");
        System.out.println("2. Lista produkter");
        System.out.println("3. Visa produktdetaljer");
        System.out.println("4. Beräkna miljöpåverkan");
        System.out.println("5. Visa återvinningsråd");
        System.out.println("6. Skapa material");
        System.out.println("7. Lista material");
        System.out.println("8. Lägg till material i produkt");
        System.out.println("9. Byt beräkningsstrategi");
        System.out.println("10. Avsluta");
        System.out.print("Välj ett alternativ: ");
    }

    private int readChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1: createProduct(); break;
            case 2: listProducts(); break;
            case 3: showProductDetails(); break;
            case 4: calculateImpact(); break;
            case 5: showRecyclingGuidance(); break;
            case 6: createMaterial(); break;
            case 7: listMaterials(); break;
            case 8: addMaterialToProduct(); break;
            case 9: switchStrategy(); break;
            case 10:
                System.out.println("Avslutar...");
                System.exit(0);
                break;
            default: System.out.println("Ogiltigt val.");
        }
    }

    private void createProduct() {
        System.out.print("Produktnamn: ");
        String name = scanner.nextLine();
        System.out.print("Kategori: ");
        String category = scanner.nextLine();
        System.out.print("Beräknad livslängd (år): ");
        int lifespan = scanner.nextInt();
        scanner.nextLine();
        service.createProduct(name, category, lifespan);
        System.out.println("Produkt skapad!");
    }

    private void listProducts() {
        List<Product> products = service.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("Inga produkter registrerade.");
        } else {
            System.out.println("\n=== PRODUKTER ===");
            for (Product p : products) {
                System.out.println("- " + p.getName() + " (" + p.getCategory() + ")");
            }
        }
    }

    private void showProductDetails() {
        System.out.print("Ange produktnamn: ");
        String name = scanner.nextLine();
        Product product = service.findProductByName(name);
        if (product == null) {
            System.out.println("Produkt hittades inte.");
        } else {
            System.out.println("\n=== PRODUKTDETALJER ===");
            System.out.println("Namn: " + product.getName());
            System.out.println("Kategori: " + product.getCategory());
            System.out.println("Livslängd: " + product.getEstimatedLifespan() + " år");
            System.out.println("Material: ");
            if (product.getMaterials().isEmpty()) {
                System.out.println("  Inga material tillagda ännu.");
            } else {
                for (Material m : product.getMaterials()) {
                    System.out.println("  - " + m.getName());
                }
            }
        }
    }

    private void calculateImpact() {
        System.out.print("Ange produktnamn: ");
        String name = scanner.nextLine();
        Product product = service.findProductByName(name);
        if (product == null) {
            System.out.println("Produkt hittades inte.");
        } else {
            double impact = service.calculateProductImpact(product);
            System.out.println("Miljöpåverkan: " + impact);
        }
    }

    private void showRecyclingGuidance() {
        System.out.print("Ange produktnamn: ");
        String name = scanner.nextLine();
        Product product = service.findProductByName(name);
        if (product == null) {
            System.out.println("Produkt hittades inte.");
        } else {
            String guidance = service.getRecyclingGuidance(product);
            System.out.println("\n=== ÅTERVINNINGSRÅD ===");
            System.out.println(guidance);
        }
    }

    private void createMaterial() {
        System.out.print("Materialnamn: ");
        String name = scanner.nextLine();
        System.out.print("Miljöpåverkan (1-10): ");
        double impact = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Återvinningskategori: ");
        String category = scanner.nextLine();
        System.out.print("Återvinningsinstruktion: ");
        String instruction = scanner.nextLine();
        service.createMaterial(name, impact, category, instruction);
        System.out.println("Material skapat!");
    }

    private void listMaterials() {
        List<Material> materials = service.getAllMaterials();
        if (materials.isEmpty()) {
            System.out.println("Inga material registrerade.");
        } else {
            System.out.println("\n=== MATERIAL ===");
            for (Material m : materials) {
                System.out.println("- " + m.getName() + " (Påverkan: " + m.getImpactValue() + ")");
            }
        }
    }

    private void addMaterialToProduct() {
        System.out.print("Ange produktnamn: ");
        String productName = scanner.nextLine();
        Product product = service.findProductByName(productName);
        if (product == null) {
            System.out.println("Produkt hittades inte.");
            return;
        }
        System.out.print("Ange materialnamn: ");
        String materialName = scanner.nextLine();
        Material material = service.findMaterialByName(materialName);
        if (material == null) {
            System.out.println("Material hittades inte. Skapa material först.");
            return;
        }
        product.addMaterial(material);
        System.out.println("Material tillagt i produkt!");
    }

    private void switchStrategy() {
        System.out.println("\n=== Välj strategi ===");
        System.out.println("1. Enkel summa");
        System.out.println("2. Viktad baserat på livslängd");
        System.out.print("Välj: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            service.setStrategy(new SimpleSumStrategy());
            System.out.println("Strategi ändrad till: Enkel summa");
        } else if (choice == 2) {
            service.setStrategy(new WeightedByLifespanStrategy());
            System.out.println("Strategi ändrad till: Viktad efter livslängd");
        } else {
            System.out.println("Ogiltigt val.");
        }
    }
}