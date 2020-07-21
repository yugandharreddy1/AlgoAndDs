package ds.io.LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DecodeString {
	public static void main(String[] args) {
		String input="3[a2[c]]";
		System.out.println(decodeString(input));
	}
	public static String decodeString(String s) {
		Stack<Integer> counts=new Stack<>();
		Stack<String> result=new Stack<>();
		String res="";
		int index=0;
		while(index<s.length()){
			char curr=s.charAt(index);
			if(Character.isDigit(curr)){
				int count=0;
				while(Character.isDigit(s.charAt(index))){
					count=10*count+(s.charAt(index)-'0');  //calculating the number from char and also checking for double digit number
					index++;
				}
				counts.push(count);
			}
			else if(curr=='['){
				result.push(res);                          //res can be populated in below areas
				res="";
				index++;
			}
			else if(curr==']'){
				StringBuilder temp=new StringBuilder(result.pop());
				int count=counts.pop();
				for(int i=0;i<count;i++){
					temp.append(res);
				}
				res=temp.toString();
				index++;
			}
			else{
				res+=curr;
				index++;
			}
		}
		return res;

	}
}
