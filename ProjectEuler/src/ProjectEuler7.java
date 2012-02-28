/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 * 
 * @author praveen
 * 
 */

public class ProjectEuler7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int primeNumberSlot = 1;
		int prime = 2;
		
		for(int i = 3; true; i += 2) {
			boolean isPrime = true;
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i%j == 0) {
					isPrime = false;
				}
			}
			if(isPrime) {
				primeNumberSlot++;
				prime = i;
				if(primeNumberSlot == 10001) {
					break;
				}
			}
		}
		
		System.out.println(prime);
	}
	
	

}
