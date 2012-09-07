public class Sqrt {

	public static void main(String args[]) {
		System.out.println(sqrt(2));
	}

	private static double sqrt(int n) {
		return find(n, 0, n + 1);
	}

	static double find(int n, double low, double high) {
		if (high - low < 0.000000001) {
			return low;
		}
		double middle = (low + high) / 2;
		double n1 = low * low;
		double n3 = middle * middle;
		if (n1 < n && n3 > n) {
			return find(n, low, middle);
		} else {
			return find(n, middle, high);
		}
	}

}
