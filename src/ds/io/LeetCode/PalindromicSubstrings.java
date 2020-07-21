package ds.io.LeetCode;

public class PalindromicSubstrings {
	public static void main(String[] args) {
		String s="aaa";
		countSubstrings(s);
	}
	public static int countSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++)
			count += countSubstrings(s, i, i) + countSubstrings(s, i, i + 1);
		return count;
	}

	private static int countSubstrings(String s, int start, int end) {
		int count = 0;
		while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) 
			count++;
		return count;
	}
}
