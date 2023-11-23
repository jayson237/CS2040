import java.util.*;

public interface StackADT {
	// check whether stack is empty
	public boolean empty(); 

	// retrieve topmost item on stack
	public Integer peek();

	// remove and return topmost item on stack
	public Integer pop();

	// insert item onto stack
	public void    push(Integer item);
}
