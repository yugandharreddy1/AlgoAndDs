package ds.io.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicatesinArray {
	public static void main(String[] args) {
		int[] nums=new int[]{4,3,2,7,8,2,3,1};
		findDuplicates(nums);
	}
	public static List<Integer> findDuplicates(int[] nums) {
		Map<Integer,Integer> map=new HashMap<>();
		List<Integer> list=new ArrayList<>();

		for(int i:nums){
			if(map.get(i)==null){
				map.put(i,1);
			}
			else{
				list.add(i);
			}

		}

		return list;

	}
}
