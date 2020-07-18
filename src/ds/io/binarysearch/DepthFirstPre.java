package ds.io.binarysearch;

public class DepthFirstPre {

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
		preOrder(nodeA);
	}

	static void preOrder(Node root) {
	if(root==null){
		return;
	}
	System.out.println(root.getData());
	preOrder(root.getLeftNode());
	preOrder(root.getRightNode());	
	}
}
