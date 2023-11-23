import java.util.*;
public class TestQueue {
	public static void main (String[] args) {

		// you can use any one of the following implementation
		//QueueLL queue= new QueueLL(); // LinkedList composition
		QueueArr queue= new QueueArr(); // Array
		//LinkedList<Integer> queue= new LinkedList<Integer> (); // Java API LinkedList implementation of the Queue interface

		System.out.println("queue is empty? " + queue.empty());
		queue.offer(1);
		System.out.println("operation: queue.offer(1)");
		System.out.println("queue is empty? " + queue.empty());
		System.out.println("front now is: " + queue.peek());
		queue.offer(2);
		System.out.println("operation: queue.offer(2)");
		System.out.println("front now is: " + queue.peek());
		queue.offer(3);
		System.out.println("operation: queue.offer(3)");
		System.out.println("front now is: " + queue.peek());
		queue.poll();
		System.out.println("operation: queue.poll()");
		System.out.println("front now is: " + queue.peek());
		System.out.print("checking whether queue.peek().equals(1): ");
		System.out.println(queue.peek().equals(1));
		queue.poll();
		System.out.println("operation: queue.poll()");
		System.out.println("front now is: " + queue.peek());
		queue.poll();
		System.out.println("operation: queue.poll()");
		System.out.println("front now is: " + queue.peek());
	}
}
