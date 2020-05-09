public class LLNode extends Node {
	
	/*
	 * following node
	 */
	private LLNode next;
	
	/*
	 * previous node
	 */
	private LLNode prev;
	
	/***********************
	 * Setters and getters *
	 * *********************/
	
	public void setNext(LLNode next) {
		this.next = next;
	}
	
	public LLNode getNext() {
		return this.next;
	}
	
	public LLNode getPrev() {
		return prev;
	}

	public void setPrev(LLNode prev) {
		this.prev = prev;
	}
	
	/*******************************
	 * end of setters and getters *
	 *******************************/

	/****************
	 * initializers *
	 ****************/
	
	public LLNode(int val) {
		super(val);
	}

	/***********************
	 * end of initializers *
	 ***********************/
}
