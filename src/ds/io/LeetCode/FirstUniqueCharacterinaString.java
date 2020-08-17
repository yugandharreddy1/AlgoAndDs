package ds.io.LeetCode;

public class FirstUniqueCharacterinaString {
	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println(firstUniqChar(s));
	}
	public static int firstUniqChar(String s) {
		char[] ch=s.toCharArray();
		for(char c:ch){
			if(s.indexOf(c)==s.lastIndexOf(c)){
				return s.indexOf(c);
			}
		}
		
		return -1;

	}
}
