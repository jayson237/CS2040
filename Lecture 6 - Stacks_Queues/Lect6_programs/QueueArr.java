import java.util.*;

// This implementation uses solution 2 to resolve full/empty state
class QueueArr implements QueueADT {
	public int[] arr;
	public int front, back;
	public int capacity;
	public final int INITSIZE = 1;

	public QueueArr() {
		arr = new int[INITSIZE]; // create array of integers
		front = 0; // the queue is empty
		back = 0;
		capacity = INITSIZE;
	}

	public boolean empty() { 
		return (front == back); 
	}

	public Integer peek() {
		if (empty()) return null;
		else return arr[front];
	}

	public Integer poll() {
		if (empty()) return null;
		Integer item = arr[front];
		front = (front + 1) % capacity;
		return item;
	}

	public void offer(Integer item) {
		if (((back+1)%capacity) == front) // array is full
		  enlargeArr();
		arr[back] = item;
		back = (back + 1) % capacity;
	}

	public boolean enlargeArr() {
		int newSize = capacity * 2;
		int[] temp = new int[newSize];
		if (temp == null) { // i.e. no memory allocated to array of E objects
		  System.out.println("Not enough memory");
      System.exit(1);
    }
		for (int j=0; j < capacity; j++) {
			// copy the front (1st) element, 2nd element, ...,  in the 
			// original array to the 1st (index 0), 2nd (index 1), ...,
			// position in the enlarged array
			temp[j] = arr[(front+j) % capacity];
		}
		front = 0; 
		back = capacity - 1;
		arr = temp;
		capacity = newSize;
		return true;
	}
}
