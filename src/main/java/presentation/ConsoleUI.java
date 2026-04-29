package presentation;


import main.java.application.ProductService;
import main.java.domain.Product;
import main.java.domain.Material;
import main.java.domain.SimpleSumStrategy;
import main.java.domain.WeightedByLifespanStrategy;

import java.util.Scanner;
import java.util.List

public class ConsoleUI {

    private ProductService service;
    private Scanner scanner;

    public ConsoleUI() {
        this.service = new ProductService(new SimpleSumStrategy());
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        showMenu();
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
    }

    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        ui.start();
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
}