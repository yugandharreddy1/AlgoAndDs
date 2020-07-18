package ds.io.binarysearch;

public class IsBST {

	public static void main(String[] args) {
		BinarySearchTree bts=new BinarySearchTree();
		Node<Integer> head=new Node(16);
		bts.insert(head, new Node<Integer>(25));
		bts.insert(head, new Node<Integer>(9));
		bts.insert(head, new Node<Integer>(12));
		bts.insert(head, new Node<Integer>(19));
		bts.insert(head, new Node<Integer>(11));
		
		System.out.println(isBST(head,9,25));
	}

	private static boolean isBST(Node<Integer> head, int min, int max) {
		if(head==null){
			return true;
		}
		
		
		if(head.getData()<=min|| head.getData()>max){
			return false;
		}
		
		return isBST(head.getLeftNode(),min,head.getData())&&isBST(head.getRightNode(), head.getData(), max);

		
		
	}
}
