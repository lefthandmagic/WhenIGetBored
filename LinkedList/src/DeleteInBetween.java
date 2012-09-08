public class DeleteInBetween {

	void delete(Node<Integer> n1) {
		Node<Integer> prev = null;
		while (n1.next != null) {
			n1.val = n1.next.val;
			n1 = n1.next;
			prev = n1;
		}
		if(prev != null) {
			prev.next = null;
		}
	}
}
