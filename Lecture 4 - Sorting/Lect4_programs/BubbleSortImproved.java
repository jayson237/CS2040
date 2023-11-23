// Improved Bubble Sort algorithm

public class BubbleSortImproved {

	public static void bubbleSort2(int[] a) {
		for (int i = 1; i < a.length; i++) {
			boolean isSorted = true;
			for (int j = 0; j < a.length - i; j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					isSorted = false;
				}
			}
			if (isSorted) return;
		}
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 7, 12, 3, 5, -6, 3, 8, 2, 10, -3 };

		printArray(arr);
		bubbleSort2(arr);
		printArray(arr);
	}
}

