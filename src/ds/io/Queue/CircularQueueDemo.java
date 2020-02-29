package ds.io.Queue;

import java.util.Scanner;
public class CircularQueueDemo
{

	static int Queue[] = new int[50];

	static int n;

	static int front;

	static int rear;

	public CircularQueueDemo(int size)

	{
		n=size;

		front = 0;

		rear=0;
	}

	public static void enqueue(int item)

	{
		if((rear+1) % n != front)

		{
			rear = (rear+1)%n;

			Queue[rear] = item;
		}
		else

		{
			System.out.println("Queue is full !");
		}
	}

	public static int dequeue()

	{
		int item = 0;

		if(front!=rear)
		{
			front = (front+1)%n;

			item = Queue[front];

			return item;
		}
		else
		{

			System.out.println("Can't remove element from queue");
		}
		return item;
	}

	public static void display()

	{
		int i;

		if(front != rear)
		{

			for(i=(front+1)%n ; i<rear ; i=(i+1)%n)

			{

				System.out.println(Queue[i]);
			}

		}

		else

			System.out.println("Queue is empty !");
	}

	public static void main(String args[]) 

	{

		System.out.print("Enter the size of the queue : ");

		Scanner scan = new Scanner (System.in);

		int size = scan.nextInt();

		CircularQueueDemo cqueue = new CircularQueueDemo(size);

		int x;

		boolean flag=true;

		while(flag)

		{

			System.out.print("\n 1 : Add\n 2 : Delete\n 3 : Display\n 4 : Exit\n\n\n\n Enter Choice : ");

			x = scan.nextInt();

			switch(x)

			{

			case 1 :

				System.out.print("\n Enter element u want to add in queue: ");

				int num = scan.nextInt();

				cqueue.enqueue(num);

				break;

			case 2 :

				int data = cqueue.dequeue();

				System.out.println("\n Item deleted from queue is : " + data);

				break;

			case 3 :

				cqueue.display();

				break;

			case 4 :

				flag=false;

				break;

			default :

				System.out.println("\n Wrong Choice !");

				break;
			}
		}
	}
}