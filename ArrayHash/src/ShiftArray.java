import java.util.ArrayList;
import java.util.List;

/**
 * Suppose we have an array a1, a2, ..., an, b1, b2, ..., bn. Implement an
 * algorithm to change this array to a1, b1, a2, b2, ..., an, bn.
 * 
 * @author praveen
 * 
 */
public class ShiftArray {

	public static void main(String args[]) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		System.out.println(shiftDC(list).toString());
	}

	public static <T> List<T> shift(List<T> list) {
		int i, j;
		for (i = 1, j = list.size() / 2; j < list.size(); i += 2, j++) {
			T toMove = list.get(j);
			T last = null;
			for (int k = i; k < j; k++) {
				T next = (last == null) ? list.get(k) : last;
				last = list.get(k + 1);
				list.set(k + 1, next);
			}
			list.set(i, toMove);
		}
		return list;
	}

	public static <T> List<T> shiftDC(List<T> list) {
		list = reArrange(list, 1, list.size());
		return list;
	}
	
	/**
	 * This doesn't work if n isn't a multiple of 2
	 * @param list
	 * @param p
	 * @param q
	 * @return
	 */
	public static <T> List<T> reArrange(List<T> list, int p, int q) {
		if (p == q) {
			return list;
		} else {
			int r = (p + q)/2;
			for (int i = (p + r) / 2, j = r; i < r; i++, j++) {
				T temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
			reArrange(list, p, r);
			reArrange(list, r + 1, q);
			return list;
		}
	}

}