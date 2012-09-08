
public class DoublyLinkedList<E> {
	
	DoublyNode<E> head = null;
	DoublyNode<E> tail = null;
	
	void add(E val) {
		if(head == null) {
			head = new DoublyNode<E>(val, null, null);
			tail = head;
		} else {
			tail = new DoublyNode<E>(val, null, tail);
		}
	}
	
}
