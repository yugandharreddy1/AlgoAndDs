package ds.io.LeepCode;

public class ReverseString {
	public static void main(String[] args) {
		char[] s=new char[]{'h','e','l','l','o'};
		reverseString(s);
	}


	public static void reverseString(char[] s) {
		for(int i=0;i<s.length/2;i++){
			char temp=s[i];
			s[i]=s[s.length-1-i];
			s[s.length-1-i]=temp;
		}

	}
}
