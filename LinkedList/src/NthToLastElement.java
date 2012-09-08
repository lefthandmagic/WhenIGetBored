public class NthToLastElement {

	Integer NthLastElement(SinglyLinkedList<Integer> list, int n) {
		if(list.head == null) {
			return null;
		}
		Node<Integer> ptr1 = list.head;
		Node<Integer> ptr2 = list.head;
		int count = 0;
		while (ptr1.next != null) {
			ptr1 = ptr1.next;
			count++;
			if (count > n) {
				ptr2 = ptr2.next;
			}
		}
		return (count > n) ? ptr2.val : null;
	}

}