public class Tree {
	
	/*
	 * root of tree
	 */
	private BinNode root;
	
	private int size = 0;
	
	/*
	 * inserts element into tree
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
		if (this.root = null) {
			this.root = new BinNode(value);
		} else {
			BinNode node = new BinNode(value);
			insert(node, this.root);
		}
	}
	
	public void insert (int[] values) {
		for (int x: values) {
			insert(x);
		}
	}
	
	/*
	 * gets minimun value of the tree
	 */
	public BinNode getMin() {
		BinNode current = root;
		while (current.getLeftChild() != null) {
			current = current.getLeftChild();
		}
		return current;
	}
	
	/*
	 * gets the maximun value of the tree
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

	public void InOrderPrintTraverse(BinNode node) {
		if (node.getLeftChild() != null) {
			printTraverse(node.getLeftChild());
		}
		
		System.out.print(node.getValue());
		
		if (node.getRightChild() != null) {
			printTraverse(node.getRightChild());
		}
	}

	public void traverse(BinNode node, LinkedList list) {
		if (node.getLeftChild() != null) {
			traverse(node.getLeftChild(), list);
		}
		list.push(node.getValue());
		if (node.getRightChild() != null) {
			traverse(node.getRightChild(), list);
		}
	}
	public int[] traverse() {
		LinkedList list = new LinkedList();
		traverseHelper(root, list);
		return list.toArray();
	}

	public Tree(int[] list) {
		insert(list);
	}
	
	public Tree(int root) {
		this.root = root;
	}
	
	public Tree() {}

	public static void main(String[] args) {
		Tree t = new Tree(new int[]{1,2,3,1,2,5,0,100,3,8,5,3,5});
		//t.printTraverse(t.root);
		for (int i : t.traverse()) {
			System.out.println(i);
		}
	}

}
