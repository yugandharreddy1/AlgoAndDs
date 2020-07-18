package ds.io.binarysearch;

public class BinarySearchTree {

	public static void main(String[] args) {
		Node<Integer> head=new Node(16);
		insert(head, new Node<Integer>(25));
		insert(head, new Node<Integer>(9));
		insert(head, new Node<Integer>(12));
		insert(head, new Node<Integer>(19));
		insert(head, new Node<Integer>(11));
		System.out.println(lookup(head,new Node<Integer>(19)).getData());
		DepthFirstPre dfp=new DepthFirstPre();
		dfp.preOrder(head);
	}
	
	public static Node<Integer> insert(Node<Integer> head,Node<Integer> node){
		if(head==null){
			return node;
		}
		if(node.getData()<=head.getData()){
			head.setLeftNode(insert(head.getLeftNode(),node));
		}
		else{
			head.setRightNode(insert(head.getRightNode(),node));
		}
		return head;
	}
	
	public static Node<Integer> lookup(Node<Integer> head,Node<Integer> node){
		if(head==null){
			return null;
		}
		
		if(head.getData()==node.getData()){
			return head;
		}
		if(node.getData()<=head.getData()){
			return lookup(head.getLeftNode(),node);
		}
		else{
			return lookup(head.getRightNode(),node);
		}
		
	}
}
