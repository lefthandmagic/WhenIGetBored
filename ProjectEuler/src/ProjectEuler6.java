/**
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author praveen
 * 
 */
public class ProjectEuler6 {

	public static void main(String args[]) {
		int largestPalindrome = 0;
		int largestI = 0, largestJ = 0;
		int value = 0;
		int i = 0, j = 0;
		for (i = 100; i < 1000; i++) {
			for (j = 100; j < 1000; j++) {
				value = i * j;
				if (isPalindrome(value)) {
					if(value > largestPalindrome) {
						largestPalindrome =  value;
						largestI = i;
						largestJ = j;
					}
				}
			}
		}

		System.out.println(largestI + " " + largestJ);
		System.out.println(largestPalindrome);

	}

	private static boolean isPalindrome(int value) {
		int reverse = 0;
		int originalValue = value;
		while (value > 0) {
			reverse = (reverse * 10) + (value % 10);
			value = value / 10;
		}

		if (reverse == originalValue) {
			return true;
		}

		return false;
	}

}
