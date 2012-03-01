
import java.util.LinkedList;
import java.util.List;


public class MergeSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LinkedList<Integer> sorted1 = new LinkedList<Integer>();
		sorted1.add(10);
		sorted1.add(20); sorted1.add(30);
		
		LinkedList<Integer> sorted2 = new LinkedList<Integer> ();
		sorted2.add(4); sorted2.add(8); sorted2.add(12); sorted2.add(16);
		
		List<Integer> mergedList = new LinkedList<Integer>();
		
		if(sorted1.size() == 0 && sorted2.size() == 0) {
			System.out.println("Bah! the lists can't be empty");
			return;
		}
		
		// a little dirty code...but this works! Another task TODO to optimize this stuff!
		while(true) {
			Integer firstVal = sorted1.peek();
			Integer secondVal  = sorted2.peek();
			
			if(firstVal == null && secondVal != null) {
				for(Integer val : sorted2) {
					mergedList.add(val);
				}
				break;
			} else if (firstVal != null && secondVal == null) {
				for(Integer val : sorted1) {
					mergedList.add(val);
				}
				break;
			}
			
			if(firstVal < secondVal) {
				mergedList.add(sorted1.removeFirst());
			} else {
				mergedList.add(sorted2.removeFirst());
			}
			
		}
		
		for(Integer val : mergedList) {
			System.out.println(val);
		}

	}

}
