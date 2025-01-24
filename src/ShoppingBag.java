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
    HashMap<Integer, Integer> myBag = new HashMap<Integer, Integer>();
    myBag.put(2, 3);
    myBag.put(5, 2);
    int totalPrice = 0;
    for(int i: myBag.keySet()) {
      int itemPrice = i;
      int quantity = myBag.get(i);
      int totalPriceForItem = itemPrice * quantity;
      totalPrice = totalPrice + totalPriceForItem;
    }
    
    return totalPrice;

  }
}