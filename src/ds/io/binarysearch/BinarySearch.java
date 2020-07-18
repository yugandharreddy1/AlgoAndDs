package ds.io.binarysearch;

public class BinarySearch {
	public static void main(String[] args) {
		int [] inputArray={11,22,33,44,55,66,77,88,99};
		int res=search(inputArray,77);
		
		if(res==-1){
			System.out.println("Element not found");
		}else{
			System.out.println("Element fount at"+ res);
		}
	}

	private static int search(int[] inputArray, int ele) {
		int min=0;
		int max=inputArray.length-1;
		
		while(min<=max){
			int mid=min+(max-min)/2;
			if(inputArray[mid]==ele){
				return mid;
			}
			if(inputArray[mid]>ele){
				max=mid-1;
			}
			else{
				min=mid+1;
			}
		}
		return -1;
		
	}

}
