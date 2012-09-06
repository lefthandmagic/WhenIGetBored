import java.util.Comparator;
import java.util.Stack;

/**
 * A Red Black Tree Partial Implementation
 * 
 * http://en.wikipedia.org/wiki/Red-black_tree
 * 
 * @note Only has ability to Insert and print Remove operation not implemented
 * 
 * @author praveen
 * 
 */
public class RBT {

	// root node of the tree
	private RBTNode rootNode;

	// the comparator used to put keys in order
	private Comparator<String> keyComparator;

	// constructor
	public RBT(Comparator<String> keyComparator) {
		this.keyComparator = keyComparator;
	}

	/**
	 * Method to insert a new key into the RBT Searches for the right node to
	 * insert new node. O(log n) base 2 time
	 * 
	 * @param key
	 */
	public void insert(String key) {

		// initialize the root node and color it black
		if (rootNode == null) {
			RBTNode newNode = new RBTNode(key, 1, RBTColor.BLACK);
			newNode.setParent(null);
			rootNode = newNode;
			return;
		}

		RBTNode node = rootNode;

		// O(log n) insert into the BST. Travel down to the right node
		// to insert/update value
		while (true) {
			int compareValue = keyComparator.compare(key, node.getKey());

			if (compareValue > 0) {
				if (node.getRightChild() == null) {
					RBTNode newNode = new RBTNode(key, 1, RBTColor.RED);
					newNode.setParent(node);
					node.setRightChild(newNode);
					insert_case2(newNode);
					break;
				} else {
					node = node.getRightChild();
				}
			} else if (compareValue < 0) {
				if (node.getLeftChild() == null) {
					RBTNode newNode = new RBTNode(key, 1, RBTColor.RED);
					newNode.setParent(node);
					node.setLeftChild(newNode);
					insert_case2(newNode);
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
	 * The first of the 5 insertion cases for RBT
	 * 
	 * @param node
	 */
	private void insert_case1(RBTNode node) {
		if (node.getParent() == null) {
			node.setColor(RBTColor.BLACK);
		} else {
			insert_case2(node);
		}
	}

	/**
	 * Second insert case for RBT
	 * 
	 * @param node
	 */
	private void insert_case2(RBTNode node) {
		if (node.getParent().getColor() == RBTColor.BLACK) {
			return;
		} else {
			insert_case3(node);
		}
	}
	
	/**
	 * 3rd Insert case for RBT
	 * 
	 * @param node
	 */
	private void insert_case3(RBTNode node) {
		RBTNode uncle = uncle(node);
		RBTNode grandParent;
		if ((uncle != null) && (uncle.getColor() == RBTColor.RED)) {
			node.getParent().setColor(RBTColor.BLACK);
			uncle.setColor(RBTColor.BLACK);
			grandParent = grandParent(node);
			grandParent.setColor(RBTColor.RED);
			insert_case1(grandParent);
		} else {
			insert_case4(node);
		}

	}

	/**
	 * 4th Insert case for RBT
	 * 
	 * @param node
	 */
	void insert_case4(RBTNode node)
	{
	        RBTNode grandParent = grandParent(node);
	 
	        if ((node == node.getParent().getRightChild()) && (node.getParent() == grandParent.getLeftChild())) {
	                rotateLeft(node.getParent());
	                node = node.getLeftChild();
	        } else if ((node == node.getParent().getLeftChild()) && (node.getParent() == grandParent.getRightChild())) {
	                rotateRight(node.getParent());
	                node = node.getRightChild();
	        }
	        insert_case5(node);
	}
	
	/**
	 * 5th Insert case for RBT
	 * 
	 * @param node
	 */
	void insert_case5(RBTNode node)
	{
	        RBTNode grandParent = grandParent(node);
	 
	        node.getParent().setColor(RBTColor.BLACK);
	        grandParent.setColor(RBTColor.RED);
	        if (node == node.getParent().getLeftChild()) {
	        	rotateRight(grandParent);
	        } else  {
	        	rotateLeft(grandParent);
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
	private void printUsingRecursion(RBTNode node) {

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
	 * This helps when the BST is highly unbalanced, and runs the risk of
	 * overflowing the thread's stack space.
	 * 
	 * @param bstNode
	 */
	private void printUsingHeapStack(RBTNode bstNode) {
		RBTNode node = bstNode;
		Stack<RBTNode> stack = new Stack<RBTNode>();
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

	/**
	 * Get the grand parent node of the given node
	 * 
	 * @param node
	 * @return
	 */
	private RBTNode grandParent(RBTNode node) {
		if ((node != null) && (node.getParent() != null)) {
			return node.getParent().getParent();
		} else {
			return null;
		}
	}

	/**
	 * Get the uncle node of the given node
	 * 
	 * @param node
	 * @return
	 */
	private RBTNode uncle(RBTNode node) {
		RBTNode grandParentNode = grandParent(node);
		if (grandParentNode == null) {
			return null; // No grandparent means no uncle
		}
		if (node.getParent() == grandParentNode.getLeftChild()) {
			return grandParentNode.getRightChild();
		} else {
			return grandParentNode.getLeftChild();
		}
	}
	
	/**
	 * Helper to rotate the tree left
	 * 
	 * @param node
	 */
	private void rotateLeft(RBTNode node) {
	    RBTNode rightChild = node.getRightChild();
	    replaceNode(node, rightChild);
	    node.setRightChild(rightChild.getLeftChild());
	    if (rightChild.getLeftChild() != null) {
	        rightChild.getLeftChild().setParent(node);
	    }
	    rightChild.setLeftChild(node);
	    node.setParent(rightChild);
	}

	/**
	 * Helper to rotate the tree right
	 * 
	 * @param node
	 */
	private void rotateRight(RBTNode node) {
	    RBTNode leftChild = node.getLeftChild();
	    replaceNode(node, leftChild);
	    node.setLeftChild(leftChild.getRightChild());
	    if (leftChild.getRightChild() != null) {
	        leftChild.getRightChild().setParent(node);
	    }
	    leftChild.setRightChild(node);
	    node.setParent(leftChild);
	}
	
	/**
	 * Helper to replace node
	 * 
	 * @param oldn
	 * @param newn
	 */
	private void replaceNode(RBTNode oldn, RBTNode newn) {
	    if (oldn.getParent() == null) {
	        rootNode = newn;
	    } else {
	        if (oldn == oldn.getParent().getLeftChild()) {
	            oldn.getParent().setLeftChild(newn);
	        }
	        else {
	            oldn.getParent().setRightChild(newn);
	        }
	    }
	    if (newn != null) {
	        newn.setParent(oldn.getParent());
	    }
	}

}
