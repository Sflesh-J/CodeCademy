import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Wie Heist du?");
    String customerName = sc.next();
    sc.nextLine();
    System.out.println("Wie viel Geld hast du ?");
    int money = sc.nextInt();
    sc.nextLine();
    
    FoodMenu menu = new FoodMenu();

    Customer customer = new Customer(customerName, money);
    
    TakeOutSimulator takeOutSimulator = new TakeOutSimulator(customer, menu , sc);

    takeOutSimulator.startTakeOutSimulator();
 }    
	  
	  
}
