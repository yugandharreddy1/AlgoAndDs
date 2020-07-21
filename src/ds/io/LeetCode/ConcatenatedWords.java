package ds.io.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

public class ConcatenatedWords {


	public static void main(String[] args) {
		String[] words = new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
		
		List<String> result = new ArrayList<String>();
		result=findAllConcatenatedWordsInADict(words);
	}







	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0;i< words.length;i++) {
			list.add(words[i]);
		}

		for(int i=0;i< words.length;i++) {
			for(int j=0;j< words.length;j++) {
				if(list.get(j).contains(words[i]) && list.get(j).length()>words[i].length()) {
					if(!result.contains(list.get(j)) && list.get(j).length()>4)
					result.add(list.get(j));
				}
			}
		}
		return result;

	}
}
