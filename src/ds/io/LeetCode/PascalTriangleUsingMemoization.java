package ds.io.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleUsingMemoization {

	static int[][] cache;
	public static void main(String[] args) {
		System.out.println(getRow(3));
	}
	public static List<Integer> getRow(int rowIndex) {

		//Our 2D cache, representing pascals triangle, will store values that have already been calculated
		cache = new int[rowIndex + 1][];

		//Fill each row in cache with a new array.
		for (int i = 0; i < cache.length; i++)
			cache[i] = new int[i+1];

		//Array list to store final result
		ArrayList<Integer> results = new ArrayList<>();

		for (int i = 0; i <= rowIndex; i++)
			results.add(getTriangleValue(rowIndex, i));

		return results;
	}

	//Recursive function that takes in the row of the triangle and the index in that row
	public static int getTriangleValue(int R, int i) {

		if (i == 0 || i == R)
			return 1;

		//If the value isnt in cache, calculate and store it
		if (cache[R][i] == 0)
			cache[R][i] = getTriangleValue(R - 1, i - 1) + getTriangleValue(R - 1, i);

		return cache[R][i];
	}
}