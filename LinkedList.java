public class LinkedList {
	
	/*
	 * head of list
	 */
	private LLNode head;
	
	/*
	 * tail of list
	 */
	private LLNode tail;
	
	/*
	 * length of the list
	 */
	private int size = 0;
	
	/***********************
	 * Setters and getters *
	 * *********************/
	
	public int getHead() {
		return this.head.getValue();
	}
	
	public void setHead(int val) throws Exception {
		insert(val, 0);
	}
	
	public int getTail() {
		return tail.getValue();
	}

	
	public void setTail(int val) throws Exception {
		insert(val, size);
	}
	

	public int getSize() {
		return size;
	}

	

	/*******************************
	 * end of setters and getters 
	 *******************************/
	
	/*
	 * gets value at location
	 */
	public int get(int index) throws Exception {
		return getNode(index).getValue();
	}
	
	/*
	 * gets node at location
	 */
	private LLNode getNode(int index) throws Exception {
		if (index < 0 || index >= size) {
			throw new Exception("Index out of bounds");
		}
		
		LLNode current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}
	
	/*
	 * inserts value to end
	 */
	public void push(int val) {
		LLNode e = new LLNode(val);
		if (this.head == null) {
			this.head = this.tail = e;
		} else {
			this.tail.setNext(e);
			e.setPrev(this.tail);
			this.tail = e;
		}
		
		this.size ++;
	}
	
	/*
	 * inserts at index
	 */
	public void insert(int val, int index) throws Exception {
		if (index < 0 || index > size) {
			throw new Exception("Index out of bounds");
		}
		
		LLNode x = new LLNode(val);
		
		if (size == 0) {
			this.head = this.tail = x;
			return;
		} else if (index == 0) {
			this.head.setPrev(x);
			x.setNext(this.head);
			this.head = x;
		} else if (index == this.size) {
			this.tail.setNext(x);
			x.setPrev(this.tail);
			this.tail = x;
		} else {
			LLNode next = getNode(index);
			LLNode prev = next.getPrev();
			prev.setNext(x);
			next.setPrev(x);
			x.setNext(next);
			x.setPrev(prev);
		}
		
		this.size++;
	}
	
	/*
	 * prints all values in order
	 */
	public void traverse() {
		LLNode current = head;
		
		while (current != null) {
			System.out.print(current.getValue() + " ");
			current = current.getNext();
		}
		
		System.out.print("\n");
	}
	
	/*
	 * converts to int[] array
	 */
	public int[] toArray() {
		int[] out = new int[size];
		int i = 0;
		for (LLNode current = head; current != null; current = current.getNext()) {
			out[i] = current.getValue();
			i++;
		}
		return out;
	}

	/*
	 * reverses the list
	 * Does not work
	 */
	public void reverse() {
		LLNode a,b,c;
		if (head==null) {
			return;
		} else {
			a=head;
		}
		if (a!=null && a.getNext() == null) {
			return;
		} else {
			b=a.getNext();
		}
		if (a!=null && b!=null && b.getNext()==null) {
			b.setNext(a);
			a.setNext(null);
			head=b;
			return;
		} else {
			c=b.getNext();
		}
		a.setNext(null);
		while (c!=null) {
			b.setNext(a);
			a=b;
			b=c;
			c=b.getNext();
		}
		b.setNext(a);
		head=b;

	}
	
	/****************
	 * initializers *
	 ****************/
	
	public LinkedList(int[] arr) {
		this.head = new LLNode(arr[0]);
		
		LLNode current = this.head;
		LLNode next;
		
		for (int x=1; x<arr.length; x++) {
			next = new LLNode(arr[x]);
			current.setNext(next);
			next.setPrev(current);
			current = next;
			
			if (x == arr.length - 1) {
				this.tail = next;
			}
		}
		
		this.size = arr.length;
	}
	
	public LinkedList(int head, int tail) {
		this.head = new LLNode(head);
		this.tail = new LLNode(tail);
		
		this.head.setNext(this.tail);
		this.tail.setPrev(this.head);
		
		this.size = 2;
	}
	
	public LinkedList(int head) {
		this.head = this.tail = new LLNode(head);
		
		this.size = 1;
	}
	
	public LinkedList(){};

	/***********************
	 * end of initializers *
	 ***********************/
}
