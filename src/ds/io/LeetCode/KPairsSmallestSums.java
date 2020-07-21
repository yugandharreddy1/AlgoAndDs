package ds.io.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;


public class KPairsSmallestSums {
	public static void main(String[] args) {
		int[] nums1 = new int[]{0,0,0,0,0,2,2,2,2},nums2 = {-3,22,35,56,76};
		int k = 22;
		kSmallestPairs(nums1,nums2,k);
	}
	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> result=new ArrayList<>();
		Stack<Pair> st=new Stack<Pair>();
		Stack<Pair> st2=new Stack<Pair>();
		
		for(int i=0;i<nums1.length;i++){
			for(int j=0;j<nums2.length;j++){
				List<Integer> temp=new ArrayList<>();
				temp.add(nums1[i]);
				temp.add(nums2[j]);
				if(st.size()==k && st.peek()!=null && st.peek().getSum()>nums1[i]+nums2[j]){
					st.pop();
					if(null!=st.peek() && st.peek().getSum()>nums1[i]+nums2[j]){
						while(!st.isEmpty() && st.peek().getSum()>nums1[i]+nums2[j]){
							st2.push(st.pop());
						}
					}
					st.push(new Pair(nums1[i]+nums2[j],temp));
					while(!st2.isEmpty()){
						st.push(st2.pop());
					}
				}
				else{
					if(st.isEmpty()){
						st.push(new Pair(nums1[i]+nums2[j],temp));
					}
					else{
						if(null!=st.peek() && st.peek().getSum()>nums1[i]+nums2[j]){
							while(!st.isEmpty() && st.peek().getSum()>nums1[i]+nums2[j]){
								st2.push(st.pop());
							}
						}
						if(st.size()<=k-1){
							st.push(new Pair(nums1[i]+nums2[j],temp));
						}
						
						while(!st2.isEmpty()){
							st.push(st2.pop());
						}
					}
					
				}
			}
		}
		
		while(!st.isEmpty()){
			st2.push(st.pop());
		}
		while(!st2.isEmpty()){
			result.add(st2.pop().getList());
		}
		System.out.println(result);
		return result;

	}
}

  class Pair{
	int sum;
	List<Integer> list;
	
	public Pair(int sum, List<Integer> list) {
		super();
		this.sum = sum;
		this.list = list;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public List<Integer> getList() {
		return list;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	
}