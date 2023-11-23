import java.util.*;

class ListUsingArray implements ListInterface {
	public int capacity = 1000; // size of the array
	public int num_items;       // number of items in the array
	public int[] arr = new int[capacity];

	public boolean isEmpty() { return num_items==0; }

	public int size()        { return num_items; }

  public int indexOf(int item) {
    int index = 0;

    for (int i = 0; i < num_items; i++) {
      if (arr[i] == item) 
        return index;
      else 
        index++;
    }
    return -1;
  }

  // return true if item is in the list false otherwise
  public boolean contains(int item) {
    if (indexOf(item) != -1)
      return true;
    return false;
  }

  // get item at index
  public int getItemAtIndex(int index) {
    if (index < 0 || index > size()-1) {
      System.out.println("invalid index");
      System.exit(1);
    }
    return arr[index];
  }

  // Return first item
  public int getFirst() { return getItemAtIndex(0); }

  // Return last item
  public int getLast() { return getItemAtIndex(size()-1); }

  // add item at position index, shifting all current items from index onwards to the right by 1 
  // pre: 0 <= index <= size()
  public void  addAtIndex(int index, int item) {
    if (index >= 0 && index <= size()) 
      insert(index, item);
    else { // index out of bounds
      System.out.println("invalid index");
      System.exit(1);
    }
  } 

  // Add item to front of list
  public void addFront(int item) { addAtIndex(0,item); }

  // Add item to back of list
  public void addBack(int item) { addAtIndex(size(),item); }

  // remove item at index and return it
  // pre: 0 <= index < size()
  public int removeAtIndex(int index) {
    int item=0;

    // index within bounds and list is not empty
    if (index >= 0 && index < size() && num_items != 0)
      item = remove(index);
    else { // index out of bounds
      System.out.println("invalid index or list is empty");
      System.exit(1);
    }
    return item;
  }

  // Remove first node of list
  public int removeFront() { return removeAtIndex(0); }

  // Remove last node of list
  public int removeBack() { return removeAtIndex(size()-1); }

  // Print items in list.
  public void print() {
    if (num_items == 0)
      System.out.println("Nothing to print...");
    else {
      System.out.print("List is: " + arr[0]);
      for (int i=1; i < num_items; i++)
        System.out.print(", " + arr[i]);
      System.out.println(".");
    }
  }


  /* non-interface helper methods */

  // insert item at index 
  public void insert(int index, int item) {
    if (num_items+1 > capacity) // array is full, enlarge it
      enlargeArr();
    // shift all items from last item to item at index to the right to create a gap
    for (int i=num_items-1; i >= index; i--)
      arr[i+1] = arr[i];
    arr[index] = item; // insert item in gap 
    num_items++;
  }

  // remove the item at index and return it
  public int remove(int index) {
    int item = arr[index];

    // shift all item from index+1 onwards to the left to close the gap
    for (int i=index+1; i < num_items; i++)
      arr[i-1] = arr[i];
    num_items--;

    return item;
  }

  public void enlargeArr() {
    int newSize = capacity * 2; // double size
    int[] temp = new int[newSize];

    if (temp == null) { // i.e. not enough memory to create an array of newSize
      System.out.println("run out of memory!");
      System.exit(1);
    }
    // copy the original array to the new array
    for (int j=0; j < num_items; j++)
      temp[j] = arr[j];
    arr = temp; // point arr to the new array
    capacity = newSize;
  }
}
