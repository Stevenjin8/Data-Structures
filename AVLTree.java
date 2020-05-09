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
		
	}
	
	public void insert(int val) {
		AVLNode x = new AVLNode(val);
		insert(x, this.root);
	}
	
	/****************
	 * initializers *
	 ****************/
	
	/***********************
	 * end of initializers *
	 ***********************/
}
