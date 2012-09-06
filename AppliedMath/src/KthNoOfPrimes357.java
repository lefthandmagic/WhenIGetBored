import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Design an algorithm to find the kth number such that the only prime factors
 * are 3, 5, and 7.
 * 
 * @author praveen
 * 
 */
public class KthNoOfPrimes357 {

	public static void main(String args[]) {
		System.out.println(getNthNo(14));
	}

	private static int getNthNo(int n) {
		if (n <= 0) {
			return 0;
		}
		Queue<Integer> Q3 = new LinkedList<Integer>();
		Queue<Integer> Q5 = new LinkedList<Integer>();
		Queue<Integer> Q7 = new LinkedList<Integer>();
		List<Integer> listOfNos = new LinkedList<Integer>();
		listOfNos.add(1);
		Q3.add(3); Q5.add(5);Q7.add(7);
		while (listOfNos.size() < n) {
			
			int q3 = Q3.peek();
			int q5 = Q5.peek();
			int q7 = Q7.peek();
			
			if(q3 < q5 && q3 < q7) {
				q3 = Q3.poll();
				listOfNos.add(q3);
				Q3.add(q3 * 3);
				Q5.add(q3 * 5);
				Q7.add(q3 * 7);
			} else if(q5 < q7 && q5 < q3) {
				q5 = Q5.poll();
				listOfNos.add(q5);
				Q5.add(q5 * 5);
				Q7.add(q5 * 7);
			} else {
				q7 = Q7.poll();
				listOfNos.add(q7);
				Q7.add(q7 * 7);
			}
			
		}
		return listOfNos.get(n - 1);
	}
}
