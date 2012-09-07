public class MergeSort {

	public static void main(String args[]) {
		int[] arr = { 123, 24, 2312, 23, 24, 21, 123, 435, 323 };         
		mergeSort(arr, 0, arr.length - 1);
		for(int i =0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void mergeSort(int arr[], int first, int last) {
		if (first < last) {
			int r = (first + last) / 2;
			mergeSort(arr, first, r);
			mergeSort(arr, r + 1, last);
			int end_low = r;
			int start_high = r + 1;
			while ((first <= end_low) && (start_high <= last)) {
				if (arr[first] < arr[start_high]) {
					first++;
				} else {
					int Temp = arr[start_high];
					for (int k = start_high - 1; k >= first; k--) {
						arr[k + 1] = arr[k];
					}
					arr[first] = Temp;
					first++;
					end_low++;
					start_high++;
				}
			}
		}

	}

}
