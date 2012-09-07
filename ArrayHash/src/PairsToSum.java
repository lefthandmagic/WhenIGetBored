import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design an algorithm to find all pairs of integers within an array which sum
 * to a specified value.
 * 
 * @author praveen
 * 
 */
public class PairsToSum {

	class Pair {
		public Pair(int i, int j) {
			this.n1 = i;
			this.n2 = j;
		}

		int n1;
		int n2;
	}

	List<Pair> makePairsWhichSumCorrecty(int[] nos, int sum) {
		List<Pair> pairs = new ArrayList<Pair>();
		for (int i = 0; i < nos.length; i++) {
			for (int j = i + 1; j < nos.length; j++) {
				if (nos[i] + nos[j] == sum) {
					Pair newPair = new Pair(nos[i], nos[j]);
					pairs.add(newPair);
				}
			}
		}
		return pairs;
	}
	
	List<Pair> makePairsWhichSumCorrectlyWithExtraSpace(int[] nos, int sum) {
		List<Pair> pairs = new ArrayList<Pair>();
		Map<Integer, Integer> noToTimes = new HashMap<Integer, Integer>();
		for (int i = 0; i < nos.length; i++) {
			if(noToTimes.containsKey(sum - nos[i])) {
				int notimes = noToTimes.get(sum - nos[i]);
				for(int j=0; j < notimes; j++) {
					pairs.add(new Pair(nos[i], sum - nos[i]));
				}
			} else {
				if(noToTimes.containsKey(nos[i])) {
					int times = noToTimes.get(nos[i]) + 1;
					noToTimes.put(nos[i], times);
				} else {
					noToTimes.put(nos[i], 1);
				}
			}
		}
		return pairs;
		
	}
	
	public static void main(String args[]) {
		int[] nos = { 20, 40, 20, 10, 10, 234 };
		PairsToSum root = new PairsToSum();
		System.out.println(root.makePairsWhichSumCorrecty(nos, 30).size());
		System.out.println(root.makePairsWhichSumCorrectlyWithExtraSpace(nos, 30).size());
	}

}
