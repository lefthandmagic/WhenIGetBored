import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 * A busy businessman has a number of equally important tasks which he must
 * accomplish. To decide which of the tasks to perform first, he performs the
 * following operation.
 * 
 * He writes down all his tasks in the form of a circular list, so the first
 * task is adjacent to the last task. He then thinks of a positive number. This
 * number is the random seed, which he calls n. Starting with the first task, he
 * moves clockwise (from element 1 in the list to element 2 in the list and so
 * on), counting from 1 to n. When his count reaches n, he removes that task
 * from the list and starts counting from the next available task. He repeats
 * this procedure until one task remains. It is this last task that he chooses
 * to execute.
 * 
 * Given a String[] list representing the tasks and an int n, return the task
 * which the businessman chooses to execute.
 * 
 * @author praveen
 * 
 */
public class ChooseTask {

	public static void main(String args[]) {
		String[] array = { "a", "b", "c", "d" };
		int random = 2;
		int count = 0;
		List<String> listOfTasks = new LinkedList<String>();

		// populate the input array into a linked list
		for (String a : array) {
			listOfTasks.add(a);
		}

		while (listOfTasks.size() > 0 && listOfTasks.size() != 1) {
			ListIterator<String> iterator = listOfTasks.listIterator();

			while (iterator.hasNext()) {
				iterator.next();
				count++;
				if (count == random) {
					iterator.remove();
					count = 0;
				}
			}

		}

		if (listOfTasks.size() == 0) {
			System.err.println("Err..something went wrong");
		}

		System.out.println(listOfTasks.get(0));

	}

}
