/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author praveen
 * 
 */
public class ProjectEuler5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long value = 600851475143L;
		long largestFactor = 0;
		for(long i = 2; i <= value; i ++) {
			while(value%i == 0) {
				value = value/i;
				largestFactor = i;
			}
		}
		System.out.println(largestFactor);
	}

}
