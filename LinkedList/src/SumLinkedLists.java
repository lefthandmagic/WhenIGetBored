import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. Write a function that adds the two numbers and returns the sum
 * as a linked list. EXAMPLE: input: (3 -> 1 -> 5), (5 -> 9 -> 2) output: 9 -> 0
 * -> 7
 * 
 * @author praveen
 * 
 */
public class SumLinkedLists {

	List<Integer> sumOfLists(List<Integer> list1, List<Integer> list2) {
		List<Integer> sum = new LinkedList<Integer>();

		ListIterator<Integer> iterator1 = list1.listIterator();
		ListIterator<Integer> iterator2 = list2.listIterator();
		Integer val1 = 0;
		while (iterator1.hasNext()) {
			int tmpval = iterator1.next();
			val1 = val1 * 10 + tmpval;
		}
		Integer val2 = 0;
		while (iterator2.hasNext()) {
			int tmpval = iterator2.next();
			val2 = val2 * 10 + tmpval;
		}

		Integer val3 = val1 + val2;
		val3 = reverse(val3);

		while (val3 > 0) {
			int rem = val3 % 10;
			val3 = val3 / 10;
			sum.add(rem);
		}
		return sum;
	}

	private Integer reverse(Integer val3) {
		int rev = 0;
		while (val3 > 0) {
			int temp = val3 % 10;
			val3 = val3 / 10;
			rev = rev * 10 + temp;
		}
		return rev;
	}

}
