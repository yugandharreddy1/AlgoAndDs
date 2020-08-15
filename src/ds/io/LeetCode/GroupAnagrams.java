package ds.io.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] arr=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(arr);
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] ca=strs[i].toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)){
               map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(strs[i]);
            
         }
        
        return new ArrayList<>(map.values());
    }
}
