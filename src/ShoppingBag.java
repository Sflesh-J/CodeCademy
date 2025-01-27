import java.util.HashMap;
import java.util.Map;

// Create ShoppingBag class here

public class ShoppingBag<T extends PricedItem<Integer>>{
  private Map<T, Integer> shoppingBag;

  public ShoppingBag(){
    this.shoppingBag = new HashMap<>();
  }
  

  public void addItem(T item){
    if(shoppingBag.containsKey(item)){
      shoppingBag.put(item, shoppingBag.get(item) + 1);
    }
    else{
      shoppingBag.put(item, 1);
    }
  }

  public int getTotalPrice(){
    int totalPrice = 0;
    for(T i: shoppingBag.keySet()) {
      int itemPrice = i.getPrice();
      int quantity = shoppingBag.get(i);
      int totalPriceForItem = itemPrice * quantity;
      totalPrice = totalPrice + totalPriceForItem;
    }
    
    return totalPrice;

  }
}