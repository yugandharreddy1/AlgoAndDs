package ds.io.binarysearch;

import java.util.Queue;

import ds.io.queue.CircularQueueDemo;

public class BreadthFirstTraversal {
	public static void main(String[] args) {
		Node nodeA=new Node("A");
		Node nodeB=new Node("B");
		Node nodeC=new Node("C");
		nodeA.setLeftNode(nodeB);
		nodeA.setRightNode(nodeC);
		Node nodeD=new Node("D");
		nodeC.setLeftNode(nodeD);
		Node nodeE=new Node("E");
		nodeC.setRightNode(nodeE);
		nodeD.setLeftNode(new Node("F"));
		nodeD.setRightNode(new Node("G"));
		nodeE.setLeftNode(new Node("H"));
		nodeE.setRightNode(new Node("I"));
		breadthFirst(nodeA);
	}

	
	public static void breadthFirst(Node root){
		if(root==null){
			return;
		}
		
		CircularQueueDemo<Node> queue=new CircularQueueDemo<>(Node.class);
		queue.enqueue(root);
		
		while(!queue.isEmpty()){
			Node node=queue.dequeue();
			System.out.println(node.getData());
			if(node.getLeftNode()!=null){
				queue.enqueue(node.getLeftNode());
			}
			if(node.getRightNode()!=null){
				queue.enqueue(node.getRightNode());
			}
		}
		
	}
}
