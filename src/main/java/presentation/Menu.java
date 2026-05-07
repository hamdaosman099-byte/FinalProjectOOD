package presentation;
 
import java.util.Scanner;
 
public class Menu {
 
    private Scanner scanner;
 
    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }
 
public void showMenu() {
        System.out.println();
        System.out.println("HÅLLBART PRODUKTSYSTEM");
        System.out.println("1) Skapa ny produkt");
        System.out.println("2) Visa alla produkter");
        System.out.println("3) Visa produktinformation");
        System.out.println("4) Räkna ut miljöpåverkan");
        System.out.println("5) Visa återvinningsinfo");
        System.out.println("6) Lägg till material");
        System.out.println("7) Visa material");
        System.out.println("8) Koppla material till produkt");
        System.out.println("9) Byt beräkningsmetod");
        System.out.println("10) Avsluta");
        System.out.print("Ange ditt val: ");
    }
 
public int readChoice() {
        int choice;

        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); 
                break;
            } else {
                System.out.print("Felaktig input, försök igen: ");
                scanner.next(); 
            }
        }

        return choice;
    }
}