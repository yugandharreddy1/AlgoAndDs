package ds.io.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int [] inputArray={4,2,5,1,8,6,9,3,7,10};

		printArray(inputArray);
		QuickSort(inputArray,0,inputArray.length-1);
		printArray(inputArray);
	}

	
	
	private static void QuickSort(int[] inputArray, int low, int high) {
	 if(low<high){
		 int pi=partition(inputArray,low,high);
		 
		 QuickSort(inputArray, low, pi-1);
		 QuickSort(inputArray, pi+1,high);
	 }
		
	}



	private static int partition(int[] inputArray, int low, int high) {
		int pivot=inputArray[high];
		int i=low-1;
		for(int j=low;j<high;j++){
			if(inputArray[j]<pivot){
				i++;
				swap(inputArray,i,j);
			}
		}
		swap(inputArray,i+1,high);
		System.out.println(pivot);
		printArray(inputArray);
		return i+1;
		
		
	}



	public static void swap(int[] inputArray,int i,int j){
		int temp=inputArray[i];
		inputArray[i]=inputArray[j];
		inputArray[j]=temp;
	}
	
	public static void printArray(int[] input){
		System.out.println("===================================");
		for(int i:input){
			System.out.print(i+" ,");
		}
		System.out.println();
		System.out.println("===================================");
	}


}
