/**
 * Write a function that adds two numbers. You should not use + or any arithme-
 * tic operators.
 * 
 * @author praveen
 * 
 */
public class AddWithoutOperator {
	public static void main(String args[]) {
		System.out.println(addwithoutop(760, 675));
	}

	private static int addwithoutop(int a, int b) {
		if (b == 0)
			return a;
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return addwithoutop(sum, carry);
	}
}
