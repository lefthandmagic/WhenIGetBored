/**
 * Write a method to count the number of 2’s between 0 and n. EXAMPLE input: 35
 * output: 14 [list of 2’s: 2, 12, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 32]
 * 
 * @author praveen
 * 
 */
public class CountTwos {

	public static void main(String args[]) {
		System.out.println(countTwo(35));
	}

	private static int countTwo(int n) {
		int count = 0;
		int i = 1;
		int modVal;
		while (i < n) {
			int temp = i;
			while (temp > 0) {
				modVal = temp % 10;
				if (modVal == 2) {
					count++;
				}
				temp = temp / 10;
			}
			i++;
		}
		return count;
	}

}
