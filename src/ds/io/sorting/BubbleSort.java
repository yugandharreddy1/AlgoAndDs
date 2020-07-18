package ds.io.sorting;

public class BubbleSort {

	public static void main(String[] args) {

		int [] inputArray={4,2,5,1,8,6,9,3,7,10};

		printArray(inputArray);
		int n=inputArray.length;
		boolean sorted;
		for(int i=0;i<n-1;i++){
			sorted=false;
			for(int j=0;j<n-i-1;j++){
				if(inputArray[j]>inputArray[j+1]){
					swap(inputArray,j,j+1);
					printArray(inputArray);
					sorted=true;
				}
			}
			if(sorted==false){
				break;
			}
		}

		printArray(inputArray);


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
