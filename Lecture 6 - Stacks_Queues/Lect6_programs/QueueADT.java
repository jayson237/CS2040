import java.util.*;

public interface QueueADT {
	// return true if queue has no elements
	public boolean  empty();

	// return the front of the queue 
	public Integer  peek();

	// remove and return the front of the queue
	public Integer  poll(); // also commonly known as dequeue

	// add item to the back of the queue
	public void offer(Integer item); // also commonly known as enqueue
}
