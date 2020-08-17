package ds.io.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[]  nums = new int []{1,1,1,2,2,3};
		topKFrequent(nums,2);

	}
	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer,Integer> map=new HashMap<>();
		for(int i:nums){
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> pq =new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
	    pq.addAll(map.entrySet());
	    
	    int[]  res = new int [k];
	    for(int i = 0; i < k; i++){
	        res[i]=pq.poll().getKey();
	    }

		return res;
	}
}
