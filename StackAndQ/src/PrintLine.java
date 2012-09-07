import java.util.LinkedList;
import java.util.Queue;

public class PrintLine {

	public class Node {
		Node left;
		Node right;
		int value;
	}

	@SuppressWarnings("unused")
	private static void PrintLineByLine(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (true) {
			if (queue.isEmpty()) {
				break;
			}
			Node node = queue.poll();
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
			System.out.println(node.value);
		}
	}

}
