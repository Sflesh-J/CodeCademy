import java.util.Scanner;

// Create TakeOutSimulator class here

public class TakeOutSimulator{
  private Customer customer;
  private FoodMenu menu;
  private Scanner input;

  public TakeOutSimulator(Customer customer, FoodMenu menu, Scanner input){
    this.customer = customer;
    this.menu = menu;
    this.input = input;
  }

  private <T> T  getResponse(String userInputPrompt, UserInputRetriever userInputRetriever){
	  while(true) {
		  System.out.println(userInputPrompt);
		  try {
			  int selection = Integer.parseInt(userInputPrompt);
			  try {
			  userInputRetriever.produceOutput(selection);
			  
			  return null;
			  }catch(Exception e){
				  System.out.println("Die Eingabe " + selection + " ist nicht Gültig!!");
				  System.out.println("Versuchen sie es nochmal:");
				  selection = input.nextInt();
			  }
		  }catch(Exception e) {
			  System.out.println("Die Eingabe darf nur eine Zahl sein!!");
			  userInputPrompt = input.nextLine();
		  }
	  }
  }

  public boolean shouldSimulate() {
	    String userPrompt = "Geben Sie 1 ein, um das Programm fortzusetzten, oder 0, um das Programm zu beenden:";

	    UserInputRetriever<Boolean> userInputRetriever = new UserInputRetriever<Boolean>() {
	        @Override
	        public Boolean produceOutput(int selection) {
	            if (selection == 1) {
	                if (customer.getMoney() >= menu.getLowestCostFood().getPrice()) {
	                    return true;
	                } else {
	                    System.out.println("Sie haben nicht genug Geld, um weiter einzukaufen");
	                    return false;
	                }
	            } else if (selection == 0) {
	                return false;
	            } else {
	                throw new IllegalArgumentException();
	            }
	        }
	    };
	    return getResponse(userPrompt, userInputRetriever);
	}

    
    
  

  public Food getMenuSelection(){
	  String userPrompt = "Biite gebe eine zugewiesene Zahl wie im Menu ein:";
	  
	  UserInputRetriever<Food> userInputRetriever = new UserInputRetriever<Food>() {
	        @Override
	        public Food produceOutput(int selection) {
	        	try {
	        		return menu.getFood(selection);
	        	}catch(Exception e) {
	        		throw new IllegalArgumentException("Ungültige Eingabe! Bitte geben Sie entweder 1 oder 2 ein.");
	        	
	        }
	        }
	        	
	    };
	    return getResponse(userPrompt, userInputRetriever);

  }
  
  public boolean isStillOrderingFood() {
	  String userPrompt = "Möchten Sie weiter einkaufen oder bezahlen?";
	  
	  UserInputRetriever<Boolean> userInputRetriever = new UserInputRetriever<Boolean>() {
	        @Override
	        public Boolean produceOutput(int selection) {
	        	
	        	if (selection == 1) {
	                return true;
	            } else if (selection == 0) {
	                return false;
	            } else {
	                throw new IllegalArgumentException("Ungültige Eingabe! Bitte geben Sie entweder 1 oder 2 ein.");
	            }
	        }
	        	
	    };
	  
	  
	  return getResponse(userPrompt, userInputRetriever);
  }
  
  
  public void checkoutCustomer(ShoppingBag<Food> shoppingBag) {
	  
	  System.out.println("Die Bezahlung ist im Gange...");
	  System.out.println("Es hat " + shoppingBag.getTotalPrice() + "€ gekostet.");
	  customer.setMoney(customer.getMoney() - shoppingBag.getTotalPrice());
	  System.out.println("Du hast noch " + customer.getMoney() + "€ zur Verfügung");
	  
  }
  
  
      void takeOutPrompt() {
	  
	  ShoppingBag<Food> shoppingBag = null;
	  while(true) {
	  int customerMoneyLeft = customer.getMoney();
	  
	  System.out.println("Du hast noch " + customerMoneyLeft + "€ übrig.");
	  
	  menu.getfoodList();
	  
	  Food selection = getMenuSelection();
	  
	  if(selection.getPrice() <= customerMoneyLeft) {
		  shoppingBag.addItem(selection);
		  customer.setMoney(customerMoneyLeft - selection.getPrice());
	  }
	  else {
		  System.out.println("Leider haben Sie nicht genügend Geld.");
		  if(isStillOrderingFood()) {
			  continue;
		  }
		  else{
			  break;
		  }
	  }
	  }
	  
	  
	  
	  
	  
  }

  public void startTakeOutSimulator(){
    System.out.println("Hallo Willkommen " + customer);
    
    takeOutPrompt();
  }
  
  
  
}