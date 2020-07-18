package ds.io.BinaryHeap;

public class MaxHeap<T extends Comparable> extends Heap<T>{

	public MaxHeap(Class<T> clazz) {
		super(clazz);
	} 
	
	public MaxHeap(Class<T> clazz,int size) {
		super(clazz,size);
	} 
	
	
	public void insert(T value){
		if(count>=array.length){
			System.out.println("heap is full");
		}

		array[0]=value;

		siftDown(count);

		count++;

	}

	public T remove(T[] array){

		T temp=getHighestPriority();
		array[0]=array[count-1];
		count--;
		siftDown(0);


		return temp;
	}


	public T getHighestPriority(){
		if(count==0){
			System.out.println("cant remove from empty");
		}

		return array[0];

	}

	
	@Override
	protected void siftUp(int index){
		int parentIndex=getParentIndex(index);

		if(parentIndex!=-1 && getElementAtIndex(parentIndex).compareTo(getElementAtIndex(parentIndex))<0){
			swap(parentIndex, index);
			siftUp(parentIndex);
		}
	}

	@Override
	protected void siftDown(int index){
		int leftIndex=getLeftChildIndex(index);
		int rightIndex=getRightChildIndex(index);


		//find the min of the left and right ele
		int smallerIndex=-1;

		if(leftIndex !=-1 && rightIndex!=-1){
			smallerIndex=getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex))<0?leftIndex: rightIndex;
		}
		else if(leftIndex!=-1){
			smallerIndex=leftIndex;
		}
		else if(rightIndex!=-1){
			smallerIndex=rightIndex;
		}


		//if left and right does not exist then  stop shifting down
		if(smallerIndex==-1){
			return;
		}


		//comapre the smaller child with current index to see if a swap
		//and further sift down is needed

		if(getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index))<0){
			swap(smallerIndex,index);
			siftDown(smallerIndex);
		}}
}
