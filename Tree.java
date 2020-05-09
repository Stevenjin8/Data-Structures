public class Tree {
	private BinNode root;

	public void insert(BinNode node, BinNode start) {
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
	}

	public BinNode getMin() {
		BinNode current = root;
		while (current.getLeftChild() != null) {
			current = current.getLeftChild();
		}
		return current;
	}

	public BinNode getMax() {
		BinNode current = root;
		while (current.getRightChild() != null) {
			current = current.getRightChild();
		}
		return current;
	}

	public boolean exists_helper(int n, BinNode node) {
		if (n == node.getValue()) {
			return true;
		} else if ((n > node.getValue() && node.getRightChild() == null) || n<= node.getValue() && node.getLeftChild() == null) {
			return false;
		} else if (n > node.getValue()) {
			return exists_helper(n, node.getRightChild());
		} else {
			return exists_helper(n, node.getLeftChild());

		}
	}

	public boolean exists(int val) {
		return exists_helper(val, root);
	}

	public int getNumElementsHelper(BinNode node) {
		if (node == null) {
			return 0;
		} else {
			return getNumElementsHelper(node.getRightChild()) + getNumElementsHelper(node.getLeftChild()) + 1;
		}
	}
	public int getNumElements() {
		return getNumElementsHelper(root);
	}

	public void printTraverse(BinNode node) {
		if (node.getLeftChild() != null) {
			printTraverse(node.getLeftChild());
		}
		System.out.println(node.getValue());
		if (node.getRightChild() != null) {
			printTraverse(node.getRightChild());
		}
	}

	public void traverseHelper(BinNode node, LinkedList list) {
		if (node.getLeftChild() != null) {
			traverseHelper(node.getLeftChild(), list);
		}
		list.push(node.getValue());
		if (node.getRightChild() != null) {
			traverseHelper(node.getRightChild(), list);
		}
	}
	public int[] traverse() {
		LinkedList list = new LinkedList();
		traverseHelper(root, list);
		return list.toArray();
	}

	public Tree(int[] list) {
		root = new BinNode(list[0]);
		for (int i=1; i<list.length; i++) {
			insert(new BinNode(list[i]), root);
		}

	}

	public static void main(String[] args) {
		Tree t = new Tree(new int[]{1,2,3,1,2,5,0,100,3,8,5,3,5});
		//t.printTraverse(t.root);
		for (int i : t.traverse()) {
			System.out.println(i);
		}
	}

}
