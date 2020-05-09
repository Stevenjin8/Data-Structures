public class BinNode extends Node {
	/*
	 * parent node
	 */
	private BinNode parent;
	
	/*
	 * left child
	 */
	private BinNode leftChild;
	
	/*
	 * right child
	 */
	private BinNode rightChild;
	
	/***********************
	 * Setters and getters *
	 * *********************/
	
	public BinNode getParent() {
		return parent;
	}

	public void setParent(BinNode parent) {
		this.parent = parent;
	}

	public BinNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinNode leftChild) {
		this.leftChild = leftChild;
	}

	public BinNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinNode rightChild) {
		this.rightChild = rightChild;
	}
	
	/*******************************
	 * end of setters and getters *
	 *******************************/
	
	/****************
	 * initializers *
	 ****************/
	
	public BinNode(BinNode parent, BinNode leftChild, BinNode rightChild, int value) {
		super(value);
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = leftChild;
	}

	public BinNode(BinNode leftChild, BinNode rightChild, int value) {
		this(null, leftChild, rightChild, value);
	}

	public BinNode(int value) {
		this(null, null, null, value);
	}

	/***********************
	 * end of initializers *
	 ***********************/
}
