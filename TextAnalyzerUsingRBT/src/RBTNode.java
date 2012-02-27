/**
 * A node in the Red Black Tree
 * 
 * @author praveen
 *
 */
public class RBTNode {
	
	// the key of each node
	private final String key;
	// the value associated with the key
	private Integer value;
	// the color of the RBTNode
	private RBTColor color;
	// left child object
	private RBTNode leftChild;
	// right child object
	private RBTNode rightChild;
	// parent object
	private RBTNode parent;
	
	// constructor
	public RBTNode(String key, Integer value, RBTColor color) {
		this.key = key;
		this.setValue(value);
		this.setColor(color);
	}

	/**
	 * Left child accessor
	 * @return
	 */
	public RBTNode getLeftChild() {
		return leftChild;
	}
	

	/**
	 * Left child setter
	 * 
	 * @param leftChild
	 */
	public void setLeftChild(RBTNode leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * Right child accessor
	 * @return
	 */
	public RBTNode getRightChild() {
		return rightChild;
	}

	/**
	 * Right child setter
	 * @param rightChild
	 */
	public void setRightChild(RBTNode rightChild) {
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

	/**
	 * Accessor for the color of the RBT Node
	 * 
	 * @return
	 */
	public RBTColor getColor() {
		return color;
	}

	/**
	 * Set the color of the RBT Node
	 * @param color
	 */
	public void setColor(RBTColor color) {
		this.color = color;
	}

	/**
	 * Accessor for the parent
	 * @return
	 */
	public RBTNode getParent() {
		return parent;
	}

	/**
	 * Setter for parent
	 * @param parent
	 */
	public void setParent(RBTNode parent) {
		this.parent = parent;
	}

}
