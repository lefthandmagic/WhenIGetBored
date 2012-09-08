public class SinglyLinkedList<E> {

	Node<E> head = null;
	Node<E> tail = null;

	void add(E val) {
		if (head == null) {
			head = new Node<E>(val, null);
			tail = head;
		} else {
			tail = new Node<E>(val, null);
		}
	}

	E delete(E val) {
		if (head == null) {
			return null;
		}
		if (head.val == val) {
			head = head.next;
		}
		Node<E> prevNode = head;
		Node<E> node = head.next;
		while (node.next != null) {
			if (node.val == val) {
				prevNode.next = node.next;
				return val;
			}
			prevNode = node;
			node = node.next;
		}
		return null;
	}

}
