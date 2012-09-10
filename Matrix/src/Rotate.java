public class Rotate {

	/**
	 * Assuming matrix is n by n
	 * 
	 * @param matrix
	 * @return
	 */
	Integer[][] transpose(Integer[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - i - j][i] = temp;
			}
		}
		return matrix;
	}

	Integer[][] rotate(Integer[][] matrix) {
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int top = matrix[first][i];
				matrix[first][i] = matrix[first][last - i];
				matrix[first][last -i ] = matrix[last - i][last];
				matrix[last - i][last] = matrix[last - i][first];
				matrix[last - i][first] = top;
			}
		}
		return matrix;
	}

}
