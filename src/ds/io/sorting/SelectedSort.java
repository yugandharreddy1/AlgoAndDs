package ds.io.sorting;

public class SelectedSort {

	public static void main(String[] args) {
		int [] inputArray={4,2,5,1,8,6,9,3,7,10};

		printArray(inputArray);

		for(int i=0;i<inputArray.length;i++){
			for(int j=i+1;j<inputArray.length;j++){
				if(inputArray[i]>inputArray[j]){
					swap(inputArray,i,j);
					printArray(inputArray);
				}
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
