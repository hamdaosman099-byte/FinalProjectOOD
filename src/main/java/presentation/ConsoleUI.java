package presentation;

import application.ProductService;
import domain.Product;
import domain.Material;
import domain.SimpleSumStrategy;
import domain.WeightedByLifespanStrategy;

import java.util.Scanner;
import java.util.List;

public class ConsoleUI {

    private ProductService service;
    private Scanner scanner;
    private Menu menu;

    public ConsoleUI() {
        service = new ProductService(new SimpleSumStrategy());
        scanner = new Scanner(System.in);
        menu = new Menu(scanner);
    }

    public void start() {
        while (true) {
            menu.showMenu();
            int choice = menu.readChoice();
            handleChoice(choice);
        }
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
            default:
                System.out.println("Ogiltigt val.");
        }
    }

    // PRODUKTER 

    private void createProduct() {
        System.out.print("Namn: ");
        String name = scanner.nextLine();

        System.out.print("Kategori: ");
        String category = scanner.nextLine();

        System.out.print("Livslängd: ");
        int lifespan = scanner.nextInt();
        scanner.nextLine();

        service.createProduct(name, category, lifespan);
        System.out.println("Produkt skapad.");
    }

    private void listProducts() {
        List<Product> products = service.getAllProducts();

        if (products.isEmpty()) {
            System.out.println("Inga produkter.");
            return;
        }

        for (Product p : products) {
            System.out.println(p.getName());
        }
    }

    private void showProductDetails() {
        System.out.print("Produktnamn: ");
        String name = scanner.nextLine();

        Product p = service.findProductByName(name);

        if (p == null) {
            System.out.println("Finns inte.");
            return;
        }

        System.out.println("Namn: " + p.getName());
        System.out.println("Kategori: " + p.getCategory());
        System.out.println("Livslängd: " + p.getEstimatedLifespan());
    }

    private void calculateImpact() {
        System.out.print("Produktnamn: ");
        String name = scanner.nextLine();

        Product p = service.findProductByName(name);

        if (p == null) {
            System.out.println("Finns inte.");
            return;
        }

        double impact = service.calculateProductImpact(p);
        System.out.println("Impact: " + impact);
    }

    private void showRecyclingGuidance() {
        System.out.print("Produktnamn: ");
        String name = scanner.nextLine();

        Product p = service.findProductByName(name);

        if (p == null) {
            System.out.println("Finns inte.");
            return;
        }

        System.out.println(service.getRecyclingGuidance(p));
    }

    // MATERIAL

    private void createMaterial() {
        System.out.print("Namn: ");
        String name = scanner.nextLine();

        System.out.print("Impact: ");
        double impact = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Kategori: ");
        String category = scanner.nextLine();

        System.out.print("Instruktion: ");
        String instruction = scanner.nextLine();

        service.createMaterial(name, impact, category, instruction);
        System.out.println("Material skapat.");
    }

    private void listMaterials() {
        List<Material> materials = service.getAllMaterials();

        if (materials.isEmpty()) {
            System.out.println("Inga material.");
            return;
        }

        for (Material m : materials) {
            System.out.println(m.getName());
        }
    }

    private void addMaterialToProduct() {
        System.out.print("Produkt: ");
        String productName = scanner.nextLine();

        System.out.print("Material: ");
        String materialName = scanner.nextLine();

        Material m = service.findMaterialByName(materialName);

        if (m == null) {
            System.out.println("Material finns inte.");
            return;
        }

        service.addMaterialToProduct(productName, m);
        System.out.println("Klart.");
    }

    // STRATEGY 

    private void switchStrategy() {
        System.out.print("1 = Simple, 2 = Weighted: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            service.setStrategy(new SimpleSumStrategy());
        } else {
            service.setStrategy(new WeightedByLifespanStrategy());
        }

        System.out.println("Strategi uppdaterad.");
    }
}