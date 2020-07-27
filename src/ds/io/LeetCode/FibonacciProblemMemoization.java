package ds.io.LeetCode;

import java.util.HashMap;

public class FibonacciProblemMemoization {
	public static void main(String[] args) {
		fib(5);
	}
	static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

	private static int fib(int N) {
		if (cache.containsKey(N)) {
			return cache.get(N);
		}
		int result;
		if (N < 2) {
			result = N;
		} else {
			result = fib(N-1) + fib(N-2);
		}
		// keep the result in cache.
		cache.put(N, result);
		return result;
	}
}
