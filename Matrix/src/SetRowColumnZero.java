import java.util.HashSet;
import java.util.Set;


public class SetRowColumnZero {
	
	Integer[][] setRowColumnZero(Integer[][] matrix) {
		Set<Integer> row = new HashSet<Integer>();
		Set<Integer> column = new HashSet<Integer>();
		for(int i=0; i < matrix.length; i++) {
			for(int j=0; j < matrix[i].length; j++) {
				int val =  matrix[i][j];
				if(val == 0) {
					row.add(i);
					column.add(j);
				}
			}
		}	
		for(int i=0; i < matrix.length; i++) {
			boolean setZero = row.contains(i);
			for(int j=0; j < matrix[i].length; j++) {
				if(setZero) {
					matrix[i][j] = 0;
				} else if (column.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
		
		return matrix;
	}
}
