/**
 * Compute factorial of a no
 * 
 * Write an algorithm which computes the number of trailing zeros in n
 * factorial. EXAMPLE input: 11 output: 2 (11! = 39916800)
 * __________________________________
 * 
 * @author praveen
 * 
 */
public class Factorial {

	public static void main(String args[]) {
		System.out.println(factorial(5));
		System.out.println(NumOfTrailingZeros(26));
	}

	private static int factorial(int n) {
		if (n == 1)
			return 1;
		return n * factorial(n - 1);
	}


	private static int NumOfTrailingZeros(int num) {
		int count = 0;
		if (num < 0) {
			throw new RuntimeException("Provide a valid num");
		}
		for (int i = 5; num / i > 0; i *= 5) {
			count += num / i;
		}
		return count;
	}
}
