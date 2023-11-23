import java.util.*;

public class TestListUsingArray {
	public static void main(String [] args) {
		ListUsingArray list = new ListUsingArray();
		list.addFront(1);
		list.addFront(2);
		list.addFront(3);
		list.addBack(4);
		list.addAtIndex(2,5);
		list.print();

		System.out.println("Testing removal");
		list.removeFront();
		list.removeBack();
		list.removeAtIndex(1);
		list.print();

		if (list.contains(1)) 
			list.addFront(6);
		list.print();		
	}
}
