package ds.io.BinaryHeap;

import java.lang.reflect.Array;

public class Heap<T extends Comparable> {
	
	private static int Max_SIZE=40;
	protected T[] array;
	protected int count=0;
	
	
	public Heap(Class<T> clazz){
		this(clazz,Max_SIZE);
	}
	
	public Heap(Class<T> clazz,int size){
		array=(T[])Array.newInstance(clazz, size);
	}

	public int getLeftChildIndex(int index){
		int leftChildIndex=2*index+1;
		if(leftChildIndex>=count){
			return -1;
		}
		
		return leftChildIndex;
	}
	
	public int getRightChildIndex(int index){
		int rightChildIndex=2*index+2;
		if(rightChildIndex>=count){
			return -1;
		}
		
		return rightChildIndex;
	}
	
	public int getParentIndex(int index){
		if(index<0||index>count){
			return -1;
		}
		return (index-1)/2;
	}
	
	protected void swap(int index1,int index2){
		T tempValue=array[index1];
		array[index1]=array[index2];
		array[index2]=tempValue;
	}
	
	public int getCount(){
		return count;
	}
	
	public boolean isEmpty(){
		return count==0;
	}
	
	public boolean isFull(){
		return count==array.length;
	}
	
	public T getElementAtIndex(int index){
		return array[index];
	}

	protected void siftDown(int index) {
		// TODO Auto-generated method stub
		
	}

	protected void siftUp(int index) {
		// TODO Auto-generated method stub
		
	}
}
