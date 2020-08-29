package ds.io.LeetCode;

public class IsSubsequence {

	public static void main(String[] args) {
		String s="abc", t = "ahbgdc";
		System.out.println(isSubsequence(s,t));

	}
	public static boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;
        while(p1<s.length() && p2<t.length()){
            if(t.charAt(p2) == s.charAt(p1)){
                p1++; p2++;
            }
            else p2++;
        }
        return p1 == s.length();
    }
}
