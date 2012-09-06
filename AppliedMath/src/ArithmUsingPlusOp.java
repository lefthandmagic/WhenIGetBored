/**
 * Write a method to implement *, - , / operations. You should use only the +
 * operator
 * 
 * @author praveen
 * 
 */
public class ArithmUsingPlusOp {

	public static void main(String args[]) {
		System.out.println(multiply(-5, 10));
		System.out.println(subtract(-5, 10));
		System.out.println(divide(500, -10));
	}

	private static int multiply(int x, int y) {
		int output = 0;
		int tmp = (x < 0) ? negate(x) : x;
		for (int i = 1; i <= tmp; i++) {
			output = output + y;
		}
		if (x < 0) {
			output = negate(output);
		}
		return output;
	}

	private static int negate(int a) {
		int val = 0;
		int x = (a < 0) ? 1 : -1;
		while (a != 0) {
			a += x;
			val += x;
		}
		return val;
	}

	private static int subtract(int a, int b) {
		return a + negate(b);
	}

	private static int divide(int a, int b) {
		int val = 0;
		int divisor = (b < 0) ? negate(b) : b;
		int dividend = (a < 0) ? negate(a) : a;
		int denom = divisor;
		while (dividend >= denom) {
			denom += divisor;
			val++;
		}
		if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
			val = negate(val);
		}
		return val;
	}

}
