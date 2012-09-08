
public class DoublyNode<T> {
	
	DoublyNode<T> next;
	DoublyNode<T> previous;
	T val;
	
	DoublyNode(T val) {
		this.val = val;
	}

	public DoublyNode(T val, DoublyNode<T> next, DoublyNode<T> previous) {
		this.val = val;
		this.next = next;
		this.previous = previous;
	}

}
