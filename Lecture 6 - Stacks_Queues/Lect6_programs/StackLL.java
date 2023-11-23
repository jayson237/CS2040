import java.util.*;

class StackLL implements StackADT {
	public BasicLinkedList list;

	public StackLL() { list = new BasicLinkedList(); }

	public boolean empty() { return list.isEmpty(); }

	public Integer peek() {
	  if (!empty()) 
	  	return list.getFirst();
	  return null;
	}

	public Integer pop() {
		Integer item = peek();
		if (!empty()) list.removeFront();
		return item;
	}

	public void push(Integer item) { list.addFront(item); }
}
