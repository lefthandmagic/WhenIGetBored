import java.util.Comparator;
import java.util.Stack;

/**
 * A Binary Search Tree Partial Implementation
 * 
 * @note Only has ability to Insert and print Remove operation not implemented
 * 
 * @author praveen
 * 
 */
public class BST {

	// root node of the tree
	private BSTNode rootNode;

	// the comparator used to put keys in order
	private Comparator<String> keyComparator;

	// constructor
	public BST(Comparator<String> keyComparator) {
		this.keyComparator = keyComparator;
	}

	/**
	 * Method to insert a new key into the BST Searches for the right node to
	 * insert new node. O(log n) base 2 time
	 * 
	 * @param key
	 */
	public void insert(String key) {

		// initialize a new node
		if (rootNode == null) {
			BSTNode newNode = new BSTNode(key, 1);
			rootNode = newNode;
			return;
		}

		BSTNode node = rootNode;

		// O(log n) insert into the BST. Travel down to the right node
		// to insert/update value
		while (true) {
			int compareValue = keyComparator.compare(key, node.getKey());

			if (compareValue > 0) {
				if (node.getRightChild() == null) {
					BSTNode newNode = new BSTNode(key, 1);
					node.setRightChild(newNode);
					break;
				} else {
					node = node.getRightChild();
				}
			} else if (compareValue < 0) {
				if (node.getLeftChild() == null) {
					BSTNode newNode = new BSTNode(key, 1);
					node.setLeftChild(newNode);
					break;
				} else {
					node = node.getLeftChild();
				}
			} else {
				Integer newNodeValue = node.getValue() + 1;
				node.setValue(newNodeValue);
				break;
			}
		}

	}

	/**
	 * Global method to print out the BST in-order
	 */
	public void print() {
		printUsingHeapStack(rootNode);
	}

	/**
	 * In-order traversal of BST using recursion.
	 * 
	 * If the tree is huge. This will fall apart.
	 * 
	 * @param node
	 */
	@SuppressWarnings("unused")
	private void printUsingRecursion(BSTNode node) {

		if (node == null) {
			return;
		}
		printUsingRecursion(node.getLeftChild());
		System.out.println(node.getValue() + " " + node.getKey());
		printUsingRecursion(node.getRightChild());

	}

	/**
	 * In order travel using a heap stack.
	 * 
	 * This helps when the BST is highly unbalanced, and 
	 * runs the risk of overflowing the thread's stack space.
	 * 
	 * @param bstNode
	 */
	private void printUsingHeapStack(BSTNode bstNode) {
		BSTNode node = bstNode;
		Stack<BSTNode> stack = new Stack<BSTNode>();
		while (true) {
			if (node != null) {
				stack.add(node);
				node = node.getLeftChild();
			} else {
				if (stack.isEmpty()) {
					break;
				}
				node = stack.pop();
				System.out.println(node.getValue() + " " + node.getKey());
				node = node.getRightChild();
			}
		}
	}

}
