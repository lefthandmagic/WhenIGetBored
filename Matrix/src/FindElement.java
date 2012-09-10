/**
 * Given a matrix in which each row and each column is sorted, write a method to
 * find an element in it.
 * 
 * @author praveen
 * 
 */
public class FindElement {
	
	boolean find(Integer[][] matrix, int n) {
		int row = findRow(matrix, 0, matrix.length, n);
		int index  = findColumn(matrix, row, 0, matrix[row].length, n);
		if(matrix[row][index] == n) {
			return true;
		} else {
			return false;
		}
	}
	

	
	int findRow(Integer[][] matrix, int index0, int index1, int n) {
		if(index1 - index0 == 1) {
			return index0;
		}
		int val = (index0 + index1)/2;
		if(val > matrix[val][0]) {
			return findRow(matrix, val + 1, index1, n);
		} else {
			return findRow(matrix, index0, val+1, n);
		}
	}
	
	
	int findColumn(Integer[][] matrix, int row, int index0, int index1, int n) {
		if(index1 - index0 == 1) {
			return index0;
		}
		int val = (index0 + index1)/2;
		if(val > matrix[row][val]) {
			return findColumn(matrix,row,  val + 1, index1, n);
		} else if (val < matrix[row][val]) {
			return findColumn(matrix,row, index0, val+1, n);
		} else {
			return val;
		}
	}

}
