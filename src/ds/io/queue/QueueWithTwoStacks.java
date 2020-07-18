package ds.io.queue;

import java.util.Stack;

public class QueueWithTwoStacks<T> {

	private Stack<T> forwardStack=new Stack<>();
	private Stack<T> reverseStack=new Stack<>();

	public QueueWithTwoStacks(){

	}

	public boolean isFull(){
		return forwardStack.isFull()|| reverseStack.isFull();
	}

	public boolean isEmpty(){
		return forwardStack.isEmpty()|| reverseStack.isEmpty();
	}


	public void enque(T data){
		if(isFull()){
			System.out.println("Queue is full");
		}

		if(forwardStack.isEmpty()){
			while(!reverseStack.isEmpty()){
				forwardStack.push(reverseStack.pop());
			}

		}
		forwardStack.push(data);
	}

	public T dequeue(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
		}

		if(reverseStack.isEmpty()){
			while(!forwardStack.isEmpty()){
				reverseStack.push(forwardStack.pop());
			}
		}
		return reverseStack.pop();




	}}
