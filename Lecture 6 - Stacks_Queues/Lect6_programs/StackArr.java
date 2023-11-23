import java.util.*;

class StackArr implements StackADT {
	public int[] arr;
	public int top;
	public int capacity;
	public final int INITSIZE = 1;

	public StackArr() {
		arr = new int[INITSIZE]; // creating array of type E
		top = -1;  // empty stack - thus, top is not on an valid array element
		capacity = INITSIZE;
	}

	public boolean empty() { 
		return (top < 0); 
	}

	public Integer peek() {
		if (!empty()) 
		  return arr[top];
		return null; // use null to represent empty stack
	}

	public Integer pop() {
		Integer item = peek();
		if (item != null)
		  top--;
		return item;
	}

	public void push(Integer item) {
		if (top >= capacity - 1) 
		  enlargeArr();
		top++;
		arr[top] = item;
	}

	public void enlargeArr() {
	  int newSize = capacity * 2; // double size
    int[] temp = new int[newSize];

    if (temp == null) { // i.e. not enough memory to create an array of newSize
      System.out.println("run out of memory!");
      System.exit(1);
    }
    // copy the original array to the new array
    for (int j=0; j <= top; j++)
      temp[j] = arr[j];
    arr = temp; // point arr to the new array
    capacity = newSize;
	}
}
