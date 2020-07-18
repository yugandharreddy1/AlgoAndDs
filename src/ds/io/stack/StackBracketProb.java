package ds.io.stack;

import java.util.HashMap;
import java.util.Stack;

public class StackBracketProb {

	public static void main(String[] args) {

		String input="[[{}]()]}";

		System.out.println(checkSequence(input));

	}

	public static boolean checkSequence(String input){
		Stack s=new Stack();
		StringBuilder b=new StringBuilder();
		HashMap<String,String> h=new HashMap<>();
		h.put("[","]");
		h.put("(",")");
		h.put("{","}");

		String open="{[(";

		for(int i=0;i<input.length();i++){
			b.append(input.charAt(i));
		}

		if(input.length()%2==0){
			for(int i=0;i<input.length();i++){
				if(open.contains(String.valueOf(input.charAt(i)))){
					s.push(input.charAt(i));
				}else{
					if(h.get(s.peek().toString()).equals(String.valueOf(input.charAt(i)))){
						s.pop();
					}
				}

			}
			if(s.empty()){
				return true;
			}else{
				return false;
			}
		}
		else{
			return false;
		}



	}

}
