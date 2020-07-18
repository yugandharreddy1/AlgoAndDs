package ds.io.binarysearch;

public class DepthFirstInOrder {
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
		inOrder(nodeA);
	}

	private static void inOrder(Node root) {
	if(root==null){
		return;
	}
	
	inOrder(root.getLeftNode());
	
	System.out.println(root.getData());
	
	inOrder(root.getRightNode());	
	}
}
