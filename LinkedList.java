public class LinkedList {
	private Item head;

	public void sethead(Item item) {
		head = item;
	}
	public Item gethead() {
		return this.head;
	}

	public Item getItem(int index) {
		Item x = head;
		for (int i = 0; i < index; i++) {
			x = x.getNext();
		}
		return x;
	}

	public int length() {
		Item current = head;
		int len = 1;
		while (current.getNext() != null) {
			current = current.getNext();
			len++;
		}
		return len;
	}

	public Item getLast() {
		return getItem(length());
	}

	public void pop() {
		
	}

	public void push(int val) {
		Item item = new Item(val);
		this.getItem(this.length()-1).setNext(item);
	}

	public void insert(int val, int index) {
		Item current = getItem(index);
		Item toInsert = new Item(val, current.getNext());
		if (index != 0) {
			getItem(index-1).setNext(toInsert);
		}
	}

	public void traverse() {
		Item current = head;
		while (current != null) {
			System.out.println(current.getVal());
			current = current.getNext();
		}
	}

	public LinkedList(int[] arr) {
		this.head = new Item(arr[0]);
		Item current = this.head;
		for (int i = 1; i < arr.length; i++) {
			Item next = new Item(arr[i]);
			current.setNext(next);
			current = next;
		}
	}

	public int[] toArray() {
		int[] out = new int[length()];
		int i = 0;
		for (Item current = head; current != null; current = current.getNext()) {
			out[i] = current.getVal();
			i++;
		}
		return out;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,1};
		LinkedList l = new LinkedList(arr);
		l.push(2);
		l.traverse();
	}
}
