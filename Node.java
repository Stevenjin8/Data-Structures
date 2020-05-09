public class Node {
	
	/*
	 * value stored in the mode
	 */
	private int value;

	/***********************
	 * setters and getters *
	 * *********************/
	
	public int getValue() {
		return value;
	}

	public void setValue(int val) {
		this.value = val;
	}
	
	/*******************************
	 * end of setters and getters *
	 *******************************/
	
	/****************
	 * initializers *
	 ****************/
	
	public Node(int value) {
		this.value = value;
	}
	
	public Node() {}
	
	/***********************
	 * end of initializers *
	 ***********************/
}
