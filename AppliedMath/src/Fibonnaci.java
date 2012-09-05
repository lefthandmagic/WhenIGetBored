/**
 * Compute fibonnaci number
 * @author praveen
 *
 */
public class Fibonnaci {
	
	public static void main(String args[]) {	
		System.out.println(fibonnaci(10));	
	}

	private static int fibonnaci(int n) {
		if(n == 1) return 1;
		return n + fibonnaci(n-1);
	}
}