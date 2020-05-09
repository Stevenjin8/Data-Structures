public class BinaryTree {
	
	/*
	 * root of tree
	 */
	private BinNode root;
	
	private int size = 0;
	
	/***********************
	 * Setters and getters *
	 * *********************/
	
	public int getSize() {
		return size;
	}
	
	/*******************************
	 * end of setters and getters *
	 *******************************/
	
	/****************
	 * initializers *
	 ****************/
	
	public BinaryTree(int[] list) {
		insert(list);
	}
	
	public BinaryTree(int root) {
		this.root = new BinNode(root);
	}
	
	public BinaryTree() {}

	/***********************
	 * end of initializers *
	 ***********************/
	
	/*
	 * inserts element into tree
	 */

	/*
	 * inserts an element
	 */
	private void insert(BinNode node, BinNode start) {
		if (node.getValue() <= start.getValue()) {
			if (start.getLeftChild() == null) {
				start.setLeftChild(node);
			} else {
				insert(node, start.getLeftChild());
			}
		} else {
			if (start.getRightChild() == null) {
				start.setRightChild(node);
			} else {
				insert(node, start.getRightChild());
			}
		}
		
		this.size++;
	}

	public void insert(int value) {
		if (this.root == null) {
			this.root = new BinNode(value);
		} else {
			BinNode node = new BinNode(value);
			insert(node, this.root);
		}
	}
	
	public void insert(int[] values) {
		for (int x: values) {
			insert(x);
		}
	}
	
	/*
	 * gets minimum value of the tree
	 */
	public BinNode getMin() {
		BinNode current = root;
		while (current.getLeftChild() != null) {
			current = current.getLeftChild();
		}
		return current;
	}
	
	/*
	 * gets the maximum value of the tree
	 */
	public BinNode getMax() {
		BinNode current = root;
		while (current.getRightChild() != null) {
			current = current.getRightChild();
		}
		return current;
	}
	
	/*
	 * checks if value is contained
	 */
	private boolean contains(int n, BinNode node) {
		if (n == node.getValue()) {
			return true;
		} else if ((n > node.getValue() && node.getRightChild() == null) || n<= node.getValue() && node.getLeftChild() == null) {
			return false;
		} else if (n > node.getValue()) {
			return contains(n, node.getRightChild());
		} else {
			return contains(n, node.getLeftChild());

		}
	}

	public boolean contains(int val) {
		return contains(val, this.root);
	}
	
	
	/*
	 * prints items in order
	 */
	public void InOrderPrintTraverse(BinNode node) {
		if (node.getLeftChild() != null) {
			InOrderPrintTraverse(node.getLeftChild());
		}
		
		System.out.print(node.getValue());
		
		if (node.getRightChild() != null) {
			InOrderPrintTraverse(node.getRightChild());
		}
	}

	public void array(BinNode node, LinkedList list) {
		if (node.getLeftChild() != null) {
			array(node.getLeftChild(), list);
		}
		list.push(node.getValue());
		if (node.getRightChild() != null) {
			array(node.getRightChild(), list);
		}
	}
	
	public int[] array() {
		LinkedList list = new LinkedList();
		array(root, list);
		return list.toArray();
	}

	public static void main(String[] args) {
		BinaryTree t = new BinaryTree(new int[]{1,2,3});
		//t.printTraverse(t.root);
		int[] l = {1,2,3};
		t.insert(l);
		for (int i : t.array()) {
			System.out.println(i);
		}
		
		System.out.println(t.contains(3));
	}

}
