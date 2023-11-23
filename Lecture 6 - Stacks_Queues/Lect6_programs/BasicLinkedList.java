import java.util.*;

class BasicLinkedList implements ListInterface {
  // attributes
  public ListNode head;
  public int num_nodes;

  // interface methods

  // Return true if list is empty; otherwise return false.
  public boolean isEmpty() { return (num_nodes == 0); }

  // Return number of items in list
  public int size() { return num_nodes; }

  // return index of item if item is found in the list, otherwise return -1
  public int indexOf(int item) {
    int index = 0;

    for (ListNode cur = head; cur != null; cur = cur.getNext()) {
      if (cur.getItem() == item) 
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
    ListNode cur = head;

    if (index < 0 || index > size()-1) {
      System.out.println("invalid index");
      System.exit(1);
    }    
    for (int counter = 0; counter != index; counter++)
      cur = cur.getNext();

    return cur.getItem();
  }

  // Return first item
  public int getFirst() { return getItemAtIndex(0); }

  // Return last item
  public int getLast() { return getItemAtIndex(size()-1); }

  // add item at position index, shifting all current items from index onwards to the right by 1 
  // pre: 0 <= index <= size()
  public void  addAtIndex(int index, int item) {
    ListNode cur;
    ListNode newNode = new ListNode(item);

    if (index >= 0 && index <= size()) {
      if (index == 0) // insert in front
        insert(null,newNode);
      else {
        cur = getNodeAtIndex(index-1); // access node at index-1
        insert(cur,newNode);
      }
    }
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
    ListNode cur;
    int item = 0;

    // index within bounds and list is not empty
    if (index >= 0 && index < size()) {
      if (index == 0) // remove 1st item
        item = remove(null);
      else {
        cur = getNodeAtIndex(index-1); // access node at index-1
        item = remove(cur);
      }
    }
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

	// Print values of nodes in list.
  public void print() {
	if (head == null)
	  System.out.println("Nothing to print...");
    else {
      ListNode cur = head;
      System.out.print("List is: " + cur.getItem());
	  for (int i=1; i < num_nodes; i++) {
	    cur = cur.getNext();
		System.out.print(", " + cur.getItem());
	  }
	  System.out.println(".");
    }
  }


  /* non-interface helper methods */
  public ListNode getHead() { return head; }

  /* return the ListNode at index */
  public ListNode getNodeAtIndex(int index) {
    ListNode cur = head;

    if (index < 0 || index > size()-1) {
      System.out.println("invalid index");
      System.exit(1);
    }    
    for (int counter = 0; counter != index; counter++)
      cur = cur.getNext();

    return cur;
  }

  // insert newNode after the node pointed to by cur 
  public void insert(ListNode cur, ListNode n) {
    // insert in front
    if (cur == null) {
      n.setNext(head);
      head = n; // update head
    }
    else { // insert anywhere esle
      n.setNext(cur.getNext());
      cur.setNext(n);
    }
    num_nodes++;
  }

  // remove the node pointed to by cur.next, and return the item in the node 
  // if cur == null, remove the first node 
  public int remove(ListNode cur) {
    int value;

    if (cur == null) { // remove 1st node
      value = head.getItem();
      head = head.getNext(); // update head
    }
    else { // remove any other node
      value = cur.getNext().getItem();
      cur.setNext(cur.getNext().getNext());
    }
    num_nodes--;

    return value;
  }
}
