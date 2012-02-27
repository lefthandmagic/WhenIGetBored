/**
 * The sum of the squares of the first ten natural numbers is,
 * 
 * 1^2 + 2^2 + ... + 10^2 = 385 
 * 
 * The square of the sum of the first ten natural
 * numbers is,
 * 
 * (1 + 2 + ... + 10)^2 = 552 = 3025 Hence the difference between the sum of the
 * squares of the first ten natural numbers and the square of the sum is 3025
 * 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 * 
 * @author praveen
 * 
 */
public class ProjectEuler3 {
	
	public static void main(String args[]) {
		
		long sumOfSquares = 0;
		long sumOfNaturalNos = 0;
		for(int i = 1; i <=100; i++) {
			sumOfNaturalNos += i;
			sumOfSquares += (i*i);
		}
		System.out.println(sumOfNaturalNos);
		System.out.println(sumOfSquares);
		long squareOfSumOfNaturalNos = sumOfNaturalNos * sumOfNaturalNos;
		System.out.println(squareOfSumOfNaturalNos - sumOfSquares);
		
	}

}
