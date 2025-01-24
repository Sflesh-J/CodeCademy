// Create PricedItem interface here

public interface PricedItem<T extends Number>{
	
  public abstract T getPrice();

  public abstract  void setPrice(T price);
}