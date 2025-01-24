// Create Customer class here

public class Customer{

  private String name;
  private int money;

  public Customer(String name, int money){
    this.name = name;
    this.money = money;
  }



public int getMoney(){
    return money;
  }

  public String getName(){
    return name;
  }

  public void setMoney(int money){
    this.money = money;
  }
  public void setName(String name){
    this.name = name;
  }
}