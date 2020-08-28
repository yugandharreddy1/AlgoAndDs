package ds.io.LeetCode;

public class MoveZero {

	public static void main(String[] args) {
		int [] nums={0,1,0,3,12};

		moveZeroes(nums);
	}
	public static void moveZeroes(int[] nums) {
		for(int i=0;i<nums.length;i++){
			int j=i+1;

			if(nums[i]==0){
				while(j<nums.length){
					if(nums[j]!=0){
						nums[i]=nums[j];
						nums[j]=0;
						break;
					}
					j++;    
				}
			}


		}

	}
}
