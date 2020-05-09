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
	 * setters and getters *
	 ***********************/
	
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

	public BinNode(BinNode leftChild, BinNode rightChild, int value) {
		super(value);
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public BinNode(int value) {
		this(null, null, value);
	}
	
	public BinNode() {}

	/***********************
	 * end of initializers *
	 ***********************/
}
