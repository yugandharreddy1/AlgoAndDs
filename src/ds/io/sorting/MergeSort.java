package ds.io.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int [] inputArray={4,2,5,1,8,6,9,3,7,10};

		printArray(inputArray);
		mergeSort(inputArray,inputArray.length);
		printArray(inputArray);
	}


	public static void mergeSort(int[] Arr, int length) {
		if (length < 2) {
			return;
		}
		int mid = length / 2;
		int[] left = new int[mid];
		int[] right = new int[length - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = Arr[i];
		}
		for (int i = mid; i < length; i++) {
			right[i - mid] = Arr[i];
		}
		mergeSort(left, mid);
		mergeSort(right, length - mid);

		merge(Arr, left, right, mid, length - mid);
	}

	public static void merge(int[] Arr, int[] leftArr, int[] rightArr, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (leftArr[i] <= rightArr[j]) {
				Arr[k++] = leftArr[i++];
			}
			else {
				Arr[k++] = rightArr[j++];
			}
		}
		while (i < left) {
			Arr[k++] = leftArr[i++];
		}
		while (j < right) {
			Arr[k++] = rightArr[j++];
		}
	}

	public static void printArray(int[] input){
		System.out.println("===================================");
		for(int i:input){
			System.out.print(i+" ,");
		}
		System.out.println();
		System.out.println("===================================");
	}


}
