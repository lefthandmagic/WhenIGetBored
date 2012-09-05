/**
 * Given two squares on a two dimensional plane, find a line that would cut
 * these two squares in half.
 * 
 * Soln: The line that cuts the squares passes between the center of both the
 * squares!
 * 
 * @author praveen
 * 
 */
public class BisectSquares {

	class Point {
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int x;
		int y;
	}

	class Line {
		Point start;
		Point end;
	}

	class Square {
		Point leftTop;
		Point rightTop;
		Point leftBottom;
		Point rightBottom;
	}

	/**
	 * Compute middle point
	 * 
	 * @param s
	 * @return
	 */
	Point middle(Square s) {
		return new Point((s.leftBottom.x + s.rightBottom.x) / 2,
				(s.leftBottom.y + s.leftTop.y) / 2);
	}

	Line cut(Square s, Square t) {
		Point middle_s = middle(s);
		Point middle_t = middle(t);
		Line line = new Line();
		if (middle_s.x == middle_t.x && middle_s.y == middle_t.y) {
			line.start = s.leftBottom;
			line.end = s.rightTop;
		} else {
			line.start = middle_s;
			line.end = middle_t;
		}
		return line;
	}

}
