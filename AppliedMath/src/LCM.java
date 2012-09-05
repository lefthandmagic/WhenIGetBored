/**
 * Compute the LCM of a given no
 * @author praveen
 *
 */
public class LCM {
	
	public static void main(String args[]) {
		LCM lcm = new LCM();
        int d = lcm.determineLCM(5, 7);
        System.out.println(d);
	}

	private int determineLCM(int i, int j) {
		int num1, num2;
		if(i > j) {
			num1 = i;
			num2 = j;
		} else {
			num2 = i;
			num1 = j;
		}
		
		for(int k=1; k <= num2; k++) {
			if((num1 * k) % num2 == 0) {
				return num1 * k;
			}
		}	
		throw new RuntimeException("Duh!");
	}
}
