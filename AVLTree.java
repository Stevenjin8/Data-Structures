public class AVLTree extends BinaryTree {
	
	private AVLNode root;
	
	/***********************
	 * setters and getters *
	 ***********************/

	
	/******************************
	 * end of setters and getters *
	 *******************************/
	

	
	/*
	 * updates the depth of nodes starting from a bottom node
	 * could make is so that it stops early, but not working
	 */
	private void updateDepths(AVLNode bottom) {
		print("------------");
		while (bottom.hasParent()) {
			bottom.updateDepth();
			bottom = bottom.getParent();
		}
		
	}
	
	/*
	 * finds alpha
	 */
	private AVLNode findAlpha(AVLNode bottom) {
		if (bottom.balanceFactor() > 1) {
			return bottom;
		} else if (bottom == this.root) {
			return null;
		} else {
			return findAlpha(bottom.getParent());
		}
	}
	
	/*
	 * returns insertion type
	 */
	public String insertionType(AVLNode alpha) {
		AVLNode firstChild;
		String out = "";
		if (alpha.getLeftChild() == null || alpha.getRightChild().getDepth() > alpha.getLeftChild().getDepth()) {
			firstChild = alpha.getRightChild();
			out += "R";
		} else {
			firstChild = alpha.getLeftChild();
			out += "L";
		}
		if (firstChild.getLeftChild() == null) {
			out += "R";
		} else if (firstChild.getRightChild() == null) {
			out += "L";
		} else if (firstChild.getRightChild().getDepth() > firstChild.getLeftChild().getDepth()) {
			out += "R";
		} else if (firstChild.getRightChild().getDepth() < firstChild.getLeftChild().getDepth()) {
			out += "L";
		}
		return out;
	}

	/*
	 * inserts a node
	 */
	
	/*
	 * inserts, updates depth and balances
	 */
	public void insert(int val) {
		//print("IN correct insert");
		AVLNode x = new AVLNode(val);
		if (this.root == null) {
			this.root = x;
		} else {
			insert(this.root,x);
		}
		
		updateDepths(x);
		
		AVLNode alpha = findAlpha(x);
		
		if (alpha == null) {
		} else {
			String type = insertionType(alpha);
			
			if (type.contentEquals("RR")) {
				CCRotate(alpha);
			} else if (type.contentEquals("RR")) {
				CWRotate(alpha);
			} else if (type.contentEquals("RL")) {
				
	
				CWRotate(alpha.getRightChild());
				CCRotate(alpha);
			} else if (type.contentEquals("LR")) {
				CCRotate(alpha.getLeftChild());
				CWRotate(alpha);
			}
		}
		
	}
	
	/*
	 * insert and updates depth, does not balance;
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
		
	}
	
	private void CCRotate(AVLNode alpha) {
		if (alpha != this.root) {
			AVLNode parent = alpha.getParent();
			AVLNode y = alpha.getRightChild();
			AVLNode a = y.getLeftChild();
			if (parent.getRightChild() == alpha) {
				parent.setRightChild(y);
			} else if (parent.getLeftChild() == alpha) {
				parent.setLeftChild(y);
			}
			y.setLeftChild(alpha);
			alpha.setRightChild(a);
			alpha.updateDepth();
			y.updateDepth();
		} else if (alpha == this.root) {
			AVLNode y = alpha.getRightChild();
			AVLNode a = y.getLeftChild();
			y.setLeftChild(alpha);
			alpha.setRightChild(a);
			this.root = y;
			alpha.updateDepth();
			y.updateDepth();
		}
	}
	
	private void CWRotate(AVLNode alpha) {
		if (alpha != this.root) {
			AVLNode parent = alpha.getParent();
			AVLNode x = alpha.getLeftChild();
			AVLNode b = x.getRightChild();
			x.setRightChild(alpha);
			alpha.setLeftChild(b);
			if (parent.getLeftChild() == alpha) {
				parent.setLeftChild(x);
			} else if (parent.getRightChild() == alpha) {
				parent.setRightChild(x);
			}
			alpha.updateDepth();
			x.updateDepth();
		} else {
			AVLNode x = alpha.getLeftChild();
			AVLNode b = x.getRightChild();
			x.setRightChild(alpha);
			alpha.setLeftChild(b);
			this.root = x;
			alpha.updateDepth();
			x.updateDepth();
		}
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
//		AVLTree t = new AVLTree();
//		t.insert(new int[] {1,2,3,4,40,7});
//		print(t.root);
//		print(t.root.getRightChild());
//		print(t.root.getLeftChild().getLeftChild());
//		print(t.root.getRightChild().getLeftChild());
//		//print(t.root.getRightChild().getRightChild().getLeftChild());
	}
}
