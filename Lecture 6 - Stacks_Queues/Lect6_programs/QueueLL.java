import java.util.*;

class QueueLL implements QueueADT {
	public TailedLinkedList list;

	public QueueLL() { list = new TailedLinkedList(); }

	public boolean empty() { return list.isEmpty(); }

	public void offer(Integer item) { list.addBack(item); }

	public Integer peek() {
		if (empty()) return null;
		return list.getFirst();
	}

	public Integer poll() {
		Integer item = peek();
		if (!empty()) list.removeFront();
		return item;
	}
}
