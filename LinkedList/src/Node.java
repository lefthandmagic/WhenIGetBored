public class Node<T> {
	
	Node<T> next;
	T val;
	
	public Node(T val, Node<T> next) {
		this.val = val;
		this.next = next;
	}

}