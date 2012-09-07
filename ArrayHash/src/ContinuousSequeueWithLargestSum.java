/**
 * You are given an array of integers (both positive and negative). Find the
 * continuous sequence with the largest sum. Return the sum. EXAMPLE input: {2,
 * -8, 3, -2, 4, -10} output: 5 [ eg, {3, -2, 4} ]
 * 
 * @author praveen
 * 
 */
public class ContinuousSequeueWithLargestSum {
	
	public static void main(String args[]) {
		int[] arr = {2, -8, 3, -2 , 4, -10};
		System.out.println(largestSequence(arr));
	}
	
	private static int largestSequence(int arr[]) {
		int startIndex = 0, endIndex = 0;
		int maxsum = 0;
		int sum = 0;
		for(int i=0; i < arr.length; i++) {
			if(sum == 0) {
				startIndex = i;
			}
			sum += arr[i];
			if(sum > maxsum) {
				maxsum = sum;
				endIndex = i;
			}
			if(sum < 0) {
				sum = 0;
			}
		}
		System.out.println("Start Index: " + startIndex + " End Index: " + endIndex);
		return maxsum;
	}

}