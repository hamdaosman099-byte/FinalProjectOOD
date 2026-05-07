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
        this.service = new ProductService(new SimpleSumStrategy());
        this.scanner = new Scanner(System.in);
        this.menu = new Menu(scanner);
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
            default: System.out.println("Ogiltigt val.");
        }
    }
 