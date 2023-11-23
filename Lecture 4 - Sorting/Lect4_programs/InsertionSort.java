// Insertion Sort algorithm

public class InsertionSort {

	public static void insertionSort(int[] a) {
		for (int i=1; i<a.length; i++) {
			int next = a[i];
			int j;
			for (j=i-1; j>=0 && a[j]>next; j--)
				a[j+1] = a[j];

			a[j+1] = next;
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
		insertionSort(arr);
		printArray(arr);
	}
}

