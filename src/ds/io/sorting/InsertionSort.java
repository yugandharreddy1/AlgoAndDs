package ds.io.sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int [] inputArray={4,2,5,1,8,6,9,3,7,10};

		printArray(inputArray);
		int n=inputArray.length;
		for(int i=0;i<n;i++){
			/*storing current element whose left side is checked for its 
            correct position .*/

			int temp = inputArray[ i ];    
			int j = i;

			/* check whether the adjacent element in left side is greater or
           less than the current element. */

			while(  j > 0  && temp < inputArray[ j -1]) {

				// moving the left side element to one position forward.
				inputArray[ j ] = inputArray[ j-1];   

				j= j - 1;

			}
			// moving current element to its  correct position.
			inputArray[ j ] = temp;     
			printArray(inputArray);
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
