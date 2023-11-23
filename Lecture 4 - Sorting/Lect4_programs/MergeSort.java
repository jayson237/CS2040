// Merge Sort algorithm

public class MergeSort {

	public static void mergeSort(int[] a) {
		mergeSort(a, 0, a.length-1);
	}

	public static void mergeSort(int[] a, int i, int j) {
		if (i < j) {
			int mid= (i+j)/2;
			mergeSort(a, i, mid);
			mergeSort(a, mid+1, j);
			merge(a, i, mid, j);
		}
	}

	public static void merge(int[] a, int i, int mid, int j) {
		// Merges the 2 sorted sub-arrays a[i..mid] and a[mid+1..j] 
		// into one sorted sub-array a[i..j]
		int[] temp = new int[j-i+1]; // temp storage
		int left = i, right = mid+1, it = 0;
		// it = next index to store merged item in temp[]

		while (left<= mid && right<=j) {
			if (a[left] <= a[right])
				temp[it++] = a[left++];
			else
				temp[it++] = a[right++];
		}

		// Copy the remaining elements into temp.
		while (left<=mid) temp[it++] = a[left++];
		while (right<=j)  temp[it++] = a[right++];

		// Copy the result in temp back into the original array a
		for (int k = 0; k < temp.length; k++)
			a[i+k] = temp[k];
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 7, 12, 3, 5, -6, 3, 8, 2, 10, -3 };

		printArray(arr);
		mergeSort(arr);
		printArray(arr);
	}
}

