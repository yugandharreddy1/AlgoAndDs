package ds.io.binarysearch;

public class BinarySearchMirror {

	public static void main(String[] args) {
		BinarySearchTree bts=new BinarySearchTree();
		Node<Integer> head=new Node(16);
		bts.insert(head, new Node<Integer>(25));
		bts.insert(head, new Node<Integer>(9));
		bts.insert(head, new Node<Integer>(12));
		bts.insert(head, new Node<Integer>(19));
		bts.insert(head, new Node<Integer>(11));

		mirror(head);
	}
	
	private static void mirror(Node<Integer> head) {

		if(head==null){
			return;
		}
		mirror(head.getLeftNode());
		mirror(head.getRightNode());

		Node<Integer> mirror=head.getLeftNode();


		mirror.setLeftNode(head.getRightNode());
		mirror.setRightNode(mirror);


	}
}
