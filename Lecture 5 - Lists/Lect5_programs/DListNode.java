class DListNode {
	/* attributes */
	public int element;
	public DListNode next; 
	public DListNode prev;

	/* constructors */
	public DListNode(int item) {
		this(item, null, null);
	}

	public DListNode(int item, DListNode p, DListNode n) {
		element = item; 
		prev = p;
		next = n;
	}

	/* get the prev DListNode */
	public DListNode getPrev() {
		return prev;
	}

	/* get the next DListNode */
	public DListNode getNext() {
		return next;
	}

	/* get the element of the DListNode */
	public int getElement() {
		return element;
	}

	/* set the prev reference */
	public void setPrev(DListNode p) {
		prev = p;
	}

	/* set the next reference */
	public void setNext(DListNode n) {
		next = n;
	}
}
