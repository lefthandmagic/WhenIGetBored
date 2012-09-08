import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 12.4 Imagine you have an unbalanced binary search tree. Design an algorithm
 * which creates a linked list of all the nodes at each depth (eg, if you have a
 * tree with depth D, you’ll have D linked lists).
 * 
 * @author praveen
 * 
 */
public class TreeToList {

	public class Node<T> {
		Node<T> left;
		Node<T> right;
		T value;
	}

	<T> List<List<Node<T>>> createLists(Node<T> node) {

		List<List<Node<T>>> list = new LinkedList<List<Node<T>>>();
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(node);
		int multiplier = 1;
		int count = 0;
		List<Node<T>> depthList = new LinkedList<Node<T>>();
		while (true) {
			if (queue.isEmpty()) {
				break;
			}
			node = queue.poll();
			if (node != null) {
				queue.add(node.left);
				queue.add(node.right);
			} else {
				queue.add(null);
				queue.add(null);
			}

			if (node != null) {
				depthList.add(node);
			}
			count++;
			if (count == multiplier) {
				list.add(depthList);
				depthList = new LinkedList<Node<T>>();
				count = 0;
				multiplier *= 2;
			}

		}
		return list;
	}
	
	
	<T> List<List<Node<T>>> createListsy(Node<T> node) {

		List<List<Node<T>>> list = new LinkedList<List<Node<T>>>();
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		Queue<Integer> depth = new LinkedList<Integer>();
		queue.add(node);
		depth.add(1);
		while (true) {
			if (queue.isEmpty()) {
				break;
			}
			node = queue.poll();
			int depthOfNode =  depth.poll();
			if(node.left != null) {
				queue.add(node.left);
				depth.add(depthOfNode +1);
			}
			if(node.right != null) {
				queue.add(node.right);
				depth.add(depthOfNode + 1);
			}
			List<Node<T>> listy =  list.get(depthOfNode - 1);
			if(listy == null) {
				listy = new LinkedList<Node<T>>();
				list.add(listy);
			}
			listy.add(node);
		}
		return list;
	}

}