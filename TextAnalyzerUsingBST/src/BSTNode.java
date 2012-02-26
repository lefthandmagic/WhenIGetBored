/**
 * A node in the binary search tree
 * @author praveen
 *
 */
public class BSTNode {
	
	// the key of each node
	private final String key;
	// the value associated with the key
	private Integer value;
	
	// left child object
	private BSTNode leftChild;
	// right child object
	private BSTNode rightChild;
	
	// constructor
	public BSTNode(String key, Integer value) {
		this.key = key;
		this.setValue(value);
	}

	/**
	 * Left child accessor
	 * @return
	 */
	public BSTNode getLeftChild() {
		return leftChild;
	}
	

	/**
	 * Left child setter
	 * 
	 * @param leftChild
	 */
	public void setLeftChild(BSTNode leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * Right child accessor
	 * @return
	 */
	public BSTNode getRightChild() {
		return rightChild;
	}

	/**
	 * Right child setter
	 * @param rightChild
	 */
	public void setRightChild(BSTNode rightChild) {
		this.rightChild = rightChild;
	}

	/**
	 * accessor for the key
	 * @return
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Accessor for the value
	 * @return
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * Value setter
	 * @param value
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

}
