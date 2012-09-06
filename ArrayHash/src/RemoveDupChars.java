/**
 * Design an algorithm and write code to remove the duplicate characters in a
 * string with- out using any additional buffer. NOTE: One or two additional
 * variables is fine. An extra copy of the array is not.
 * 
 * FOLLOW UP
 * 
 * Write the test cases for this method.
 * 
 * @author praveen
 * 
 */
public class RemoveDupChars {
	
	public static void main(String args[]) {
		System.out.println(removeDupChars("abcdsffffsdds"));
	}
	
	private static String removeDupChars(String array) {
		char[] arr = array.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			char x = arr[i];
			if(x != ' ') {
				for(int j=i+1; j < arr.length; j++) {
					if (x == arr[j]) {
						arr[j] = ' ';
					}
				}
			}
		}
		for(int i=0; i < arr.length; i++) {
			if(arr[i] == ' ') {
				for(int j=i+1; j< arr.length; j++) {
					arr[j-1] = arr[j];
				}
			}
		}
		return new String(arr);
	}

}
