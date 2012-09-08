import java.util.HashSet;
import java.util.Set;

/**
 * Write code to remove duplicates from an unsorted linked list. FOLLOW UPS &
 * COMPLICATIONS How would you solve this problem if a temporary buffer is not
 * allowed?
 * 
 * @author praveen
 * 
 */
public class RemoveDups {

	SinglyLinkedList<Integer> removeDupsWithMemory(
			SinglyLinkedList<Integer> list) {
		Set<Integer> uniqueVals = new HashSet<Integer>();
		Node<Integer> node = list.head;
		Node<Integer> prevNode = null;
		while (node != null) {
			if (uniqueVals.contains(node.val)) {
				prevNode.next = node.next;
			} else {
				uniqueVals.add(node.val);
				prevNode = node;
			}
			node = node.next;
		}
		return list;
	}

	SinglyLinkedList<Integer> removeDupsWithoutMemory(
			SinglyLinkedList<Integer> list) {
		Node<Integer> head = list.head;
		Node<Integer> node = head;
		while (node != null) {
			int val = node.val;
			Node<Integer> tempPrevNode = node;
			Node<Integer> tempNode = node.next;
			while (tempNode != null) {
				if (val == tempNode.val) {
					tempPrevNode.next = tempNode.next;
				} else {
					tempPrevNode = tempNode;
				}
				tempNode = tempNode.next;
			}
			node = node.next;
		}
		return list;
	}
}
