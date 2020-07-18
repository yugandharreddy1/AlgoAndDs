package ds.io.stack;
import java.util.*;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Test {

	public static void main(String[] args) {

		int[] s=new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxArea(s));
	}
	public static int maxArea(int[] s) {
		int sum=0;
		for(int i=0;i<s.length;i++){
			for(int j=i;j<s.length;j++){
				sum=Math.max(sum, getSum(s,i,j));
			}
		}
	
		return sum;

	}
	private static int getSum(int[] s, int k, int l) {
		int sum=0;
		for(int i=k;i<=l;i++){
			sum=sum+s[i];
		}
		return sum;
		
	}}