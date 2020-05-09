
public class AVLNode extends BinNode {
	
	/*
	 * depth of node
	 */
	private int depth;
	
	/*
	 * parent node
	 */
	private AVLNode parent;
	
	/*
	 * left child
	 */
	private AVLNode leftChild;
	
	/*
	 * right child
	 */
	private AVLNode rightChild;
	
	/***********************
	 * Setters and getters *
	 * *********************/
	
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public AVLNode getParent() {
		return parent;
	}

	public void setParent(AVLNode parent) {
		this.parent = parent;
	}

	public AVLNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(AVLNode leftChild) {
		this.leftChild = leftChild;
	}

	public AVLNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(AVLNode rightChild) {
		this.rightChild = rightChild;
	}

	/*******************************
	 * end of setters and getters *
	 *******************************/
	
	/*
	 * increases depth field of this node
	 */
	public void increaseDepth(int n) {
		this.depth += n;
	}
	
	public void increaseDepth() {
		increaseDepth(1);
	}
	
	/*
	 * returns the balance factor
	 */
	public int balanceFactor() {
		if (this.leftChild == null && this.rightChild == null) {
			return 0;
		} else if (this.leftChild == null) {
			return this.rightChild.getDepth();
		} else if (this.rightChild == null) {
			return this.leftChild.getDepth();
		} else {
			int b = this.leftChild.getDepth() - this.rightChild.getDepth();
			if (b>0) {
				return b;
			} else {
				return -b;
			}
		}
	}
	
	/****************
	 * initializers *
	 ****************/
	
	public AVLNode(int val, int depth) {
		super(val);
		this.depth = depth;
	}
	
	public AVLNode(int val) {
		super(val);
	}
	
	public AVLNode() {}
	
	/***********************
	 * end of initializers *
	 ***********************/
}
