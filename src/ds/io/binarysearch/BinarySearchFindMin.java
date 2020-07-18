package ds.io.binarysearch;

public class BinarySearchFindMin {

	public static void main(String[] args) {
		BinarySearchTree bts=new BinarySearchTree();
		Node<Integer> head=new Node(16);
		bts.insert(head, new Node<Integer>(25));
		bts.insert(head, new Node<Integer>(9));
		bts.insert(head, new Node<Integer>(12));
		bts.insert(head, new Node<Integer>(19));
		bts.insert(head, new Node<Integer>(11));

		System.out.println(findmin(head));
	}





	private static Integer findmin(Node<Integer> head) {
		if(head==null){
			return null;
		}

		if(head.getLeftNode()!=null){
			return findmin(head.getLeftNode());
		}
		else{
			return head.getData();
		}


	}

}
