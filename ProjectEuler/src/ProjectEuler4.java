/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 * 
 * @author praveen
 * 
 */
public class ProjectEuler4 {

	public static void main(String args[]) {
		
		boolean done = false;
		long result = 0;
		for(int i = 20; true; i +=20) {
			for(int j=1; j <= 20; j++) {
				if(i%j != 0) {
					break;
				} else {
					if(j == 20) {
						done = true;
					}
				}
			}
			if(done) {
				result = i;
				break;
			}
		}

		System.out.println(result);
	}

}
