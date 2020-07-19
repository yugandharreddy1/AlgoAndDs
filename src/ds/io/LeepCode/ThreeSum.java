package ds.io.LeepCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ThreeSum {
	public static void main(String[] args) {

		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };

		threeSum(nums);
	}

	private static List<List<Integer>> threeSum(int[] inputArr) {
		int SubArrSize = 3;
		int n = inputArr.length;
		int tempSubArr[] = new int[SubArrSize];
		List<List<Integer>> result = new ArrayList<>();
		result = combinations(inputArr, tempSubArr, 0, n - 1, 0, SubArrSize, result);
		return result;

	}

	private static List<List<Integer>> combinations(int[] inputArr, int[] tempSubArr, int start, int end, int index, int SubArrSize,List<List<Integer>> result) {

		// Current combination is ready to be added
		if (index == SubArrSize) {
			List<Integer> subArr = new ArrayList<>();
			int sum = 0;
			for (int j = 0; j < SubArrSize; j++) {
				subArr.add(tempSubArr[j]);
				sum = sum + tempSubArr[j];
			}
			if (sum == 0) {
				Collections.sort(subArr);
				if(!result.contains(subArr)){
					result.add(subArr);
					System.out.println(subArr);
				}
					
				
			}
			return result;
		}

		// replace index with all possible elements. The condition "end-i+1 >= r-index" makes sure that including one element at index will make a combination with remaining elements at remaining positions
		//A. r - index is the amount of elements which Should be set in the Output (data) array, from this recursion node in the recursion tree. For example if n=3 and index=2, we are currently setting only data[2], notice that 3-2=1 (indeed we can set only 1 element).
		//B. end - i + 1 is the amount of elements in the Input array, from which we can select, from this recusion node and below. For example if n=3 (end = 3-1) and i=2, we can select only (3-1)-2+1 = 1 more elements from the Input array.
		//C. Why the second amount has to be equal or bigger? Because, we need to guarantee having enough elements to select from the Input array (our source of selection), to accomplish (r - index) elements in the Output array. This is the task of the current recursion node and its successors.
		
		for (int i = start; i <= end && end - i + 1 >= SubArrSize - index; i++) {
			tempSubArr[index] = inputArr[i];
			combinations(inputArr, tempSubArr, i + 1, end, index + 1, SubArrSize, result);
		}
		return result;
	}

}
