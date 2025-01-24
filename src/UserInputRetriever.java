// Create UserInputRetriever interface here
public interface UserInputRetriever<T> {
	
  public abstract T produceOutput(int selection) throws IllegalArgumentException;
  
}