import java.util.LinkedList;
import java.util.List;

// Create FoodMenu class here
public class FoodMenu{
  private List<Food> menu = new LinkedList<>();

  public FoodMenu(){
	  menu.add(new Food("Pizza", "Mit Salami und Schinken", 12));
	    menu.add(new Food("Pizzabrot", "Sehr schön gewürzt", 8));
	    menu.add(new Food("Salat", "Mit Tomaten und Fetakäse", 10));
  }

  public void getfoodList() {
	  for(Food food : menu) {
		  System.out.println(food);
	  }
  }

  public Food getFood(int index){
	  try {
	  return menu.get(index - 1);
	  }catch(Exception e) {
		  System.out.println("Ungültige Eingabe!!");
		  return null;
	  }
  }

  public Food getLowestCostFood() {
	  int cost = 50;
	  Food foodObject = null;
	  for(Food food : menu) {
		 if(food.getPrice() < cost) {
			 cost = food.getPrice();
			 foodObject = food;
		 }
	  }
	  return foodObject;
  }
  

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    for(int i = 1; i < menu.size() + 1; i++){
      sb.append(i +". " + menu.get(i));
    }

    return sb.toString();
  }
  

}
