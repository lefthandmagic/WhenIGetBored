/**
 * Given a two dimensional graph with 6000 points on it, find a line which
 * passes the most number of points.
 * 
 * @author praveen
 * 
 */
public class LineThroughMaxPoints {

	class Point {
		int x;
		int y;
	}

	@SuppressWarnings("unused")
	private static int compute(Point[] points) {
		int maxVal = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = i; j < points.length; j++) {
				int val = numOfPoints(points, points[i], points[j]);
				if (val > maxVal) {
					maxVal = val;
				}
			}
		}
		return maxVal;
	}

	private static int numOfPoints(Point[] points, Point point1, Point point2) {
		int count = 0;
		for (int i = 0; i < points.length; i++) {
			boolean insameline = areInSameLine(point1, point2, points[i]);
			if (insameline) {
				count++;
			}
		}
		return count;
	}

	private static boolean areInSameLine(Point point1, Point point2,
			Point point3) {
		return (point1.x * (point2.y - point3.y) + point2.x
				* (point3.y - point1.y) + point3.x * (point1.y - point2.y)) == 0;
	}

}
