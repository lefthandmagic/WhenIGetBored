/**
 * 14.4 Imagine you have a square matrix, where each cell is filled with either
 * black or white. Design an algorithm to find the maximum subsquare such that
 * all four borders are filled with black pixels.
 * 
 * @author praveen
 * 
 */
public class FindMaxSubSquare {

	Boolean[][] findSubSquare(Boolean[][] square) {
		boolean isTrue = false;
		int i;
		Boolean[][] newMat = null;
		for (i = 0; i < square.length / 2; i++) {
			int start = i;
			int end = square.length - i;
			isTrue = checkAllBorders(square, start, end);
			if (isTrue)
				break;
		}

		if (isTrue) {
			int start = i;
			int end = square.length - i;
			newMat = new Boolean[start][end];
			for (i = start; i < end; i++) {
				for (int j = start; j < end; j++) {
					newMat[i - start][j - start] = square[i][j];
				}
			}
		}

		return newMat;

	}

	boolean checkAllBorders(Boolean[][] square, int start, int end) {
		for (int i = start; i < end; i++) {
			if (square[start][i] && square[end][i] && square[i][start]
					&& square[i][end]) {
				return false;
			}
		}
		return true;
	}

}
