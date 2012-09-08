/**
 * Given a circular linked list, implement an algorithm which returns node at
 * the begin- ning of the loop. DEFINITION Circular linked list: A (corrupt)
 * linked list in which a node’s next pointer points to an earlier node, so as
 * to make a loop in the linked list. EXAMPLE: input: A -> B -> C -> D -> E -> C
 * [the same C as earlier] output: C
 * 
 * @author praveen
 * 
 */
public class StartOfCircularList {

	/**
	 * floyds cycle detection algo!
	 * 
	 * @param list
	 * @return 
	 */
	Node<Integer> floyd(SinglyLinkedList<Integer> list) {
		try {
			Node<Integer> ptr1 = list.head;
			Node<Integer> ptr2 = list.head;
			while (true) {
				ptr1 = ptr1.next;
				ptr2 = ptr2.next.next;

				if (ptr1 == ptr2) {
					break;
				}
			}
			ptr1 = list.head;
			while (ptr1.next != ptr2.next) {
				ptr1 = ptr1.next;
				ptr2 = ptr2.next;
			}
			return ptr1;
		} catch (NullPointerException e) {
			throw new RuntimeException("Invalid Input");
		}

	}

}
