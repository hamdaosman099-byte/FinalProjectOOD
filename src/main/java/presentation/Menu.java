package presentation;
 
import java.util.Scanner;
 
public class Menu {
 
    private Scanner scanner;
 
    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }
 
    public void showMenu() {
        System.out.println("HÅLLBART PRODUKTSYSTEM");
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
 
    public int readChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
 