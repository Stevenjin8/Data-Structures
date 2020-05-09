public class AVLTree extends BinaryTree {
	
	private AVLNode root;
	
	/***********************
	 * setters and getters *
	 ***********************/

	
	/******************************
	 * end of setters and getters *
	 *******************************/
	
	private AVLNode alpha(AVLNode leaf) {
		AVLNode current = leaf;
		while (current.balanceFactor() <= 1) {
			current = current.getParent();
		}
		return current;
	}
	
	/*
	 * updates the depth of nodes starting from a bottom node
	 */
	private void updateDepths(AVLNode bottom) {
		bottom = bottom.getParent();
		while (bottom.updateDepth() && bottom.hasParent()) {
			bottom = bottom.getParent();
		}
		
	}
	
	/*
	 * finds alpha
	 */
	private AVLNode findAlpha(AVLNode bottom) {
		while (bottom.balanceFactor() < 2) {
			bottom = bottom.getParent();
		}
		
		return bottom;
	}
	
	/*
	 * finds which node x is under
	 */
	private AVLNode isUnder(AVLNode a, AVLNode b, AVLNode c, AVLNode d, AVLNode x) {
		if (a != null && x == a) {
			return a;
		} else if (b != null && x == b) {
			return b;
		} else if (c != null && x == c) {
			return c;
		} else if (d != null && x == d) {
			return d;
		} else {
			return isUnder(a, b, c, d, x.getParent());
		}
	}
	
	public void insert(int val) {
		AVLNode x = new AVLNode(val);
		if (this.root == null) {
			this.root = x;
		} else {
			insert(this.root,x);
		}
	}
	
	/*
	 * inserts a node
	 */
	private void insert(AVLNode current, AVLNode x) {
		if (x.getValue() > current.getValue()) {
			if (current.getRightChild() == null) {
				current.setRightChild(x);
				x.setParent(current);
			} else {
				insert(current.getRightChild(), x);
			}
		} else {
			if (current.getLeftChild() == null) {
				current.setLeftChild(x);
				x.setParent(current);
			} else {
				insert(current.getLeftChild(), x);
				
			}
		}
		
		updateDepths(x);
		
	}
	
	/****************
	 * initializers *
	 ****************/
	
	/***********************
	 * end of initializers *
	 ***********************/
	
	public static void print(Object i) {
		System.out.println(i);
	}
	
	public static void main(String args[]) {
		AVLTree t = new AVLTree();
		t.insert(10);
		t.insert(15);
		t.insert(5);
		t.insert(3);
		t.insert(0);
		AVLNode x = t.root.getLeftChild().getLeftChild().getLeftChild();
		AVLNode alpha = t.alpha(x);
		//print(x.getParent().balanceFactor());
		print(alpha);
	}
}
