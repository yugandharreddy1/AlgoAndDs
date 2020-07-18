package ds.io.queue;

import java.lang.reflect.Array;
import java.util.Scanner;
//CircularQueueDemo using array
public class CircularQueueDemo<T>
{
	private static final int SPECIAL_EMPTY_VALUE=-1;
	private static int MAX_VALUE=40;
	private T[] elements;
	
	
	private int headIndex=SPECIAL_EMPTY_VALUE;
	private int tailIndex=SPECIAL_EMPTY_VALUE;
	
	public CircularQueueDemo(Class<?> clazz){
		elements=(T[])Array.newInstance(clazz, MAX_VALUE);
	}

	
	public Boolean isFull(){
		
		int nextIndex=(tailIndex+1)%elements.length;
		
		return nextIndex==MAX_VALUE;
		
	}
	
	public Boolean isEmpty(){
		return headIndex==SPECIAL_EMPTY_VALUE;
	}

	
	
	public void enqueue(T data){
		if(isFull()){
			System.out.println("Queue is full");
		}
		else{
			tailIndex=(tailIndex+1)%elements.length;
			elements[tailIndex]=data;
			if(headIndex==SPECIAL_EMPTY_VALUE){
				headIndex=tailIndex;
			}
		}
	}
	
	
	public T dequeue(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
		}
		T data=elements[headIndex];
		if(headIndex==tailIndex){
			headIndex=SPECIAL_EMPTY_VALUE;
		}
		else{
			headIndex=(headIndex+1)%elements.length;
		}
		return data;
	}
}