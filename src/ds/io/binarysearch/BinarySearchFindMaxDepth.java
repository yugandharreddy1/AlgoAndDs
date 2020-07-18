package ds.io.binarysearch;

public class BinarySearchFindMaxDepth {
	static int leftcount=0;
	static int rightCount=0;
	public static void main(String[] args) {
		BinarySearchTree bts=new BinarySearchTree();
		Node<Integer> head=new Node(16);
		bts.insert(head, new Node<Integer>(25));
		bts.insert(head, new Node<Integer>(9));
		bts.insert(head, new Node<Integer>(12));
		bts.insert(head, new Node<Integer>(19));
		bts.insert(head, new Node<Integer>(11));

		System.out.println(findDepth(head));

	}
	private static int findDepth(Node<Integer> head) {
		if(head==null){
			return 0;
		}

		if(head.getLeftNode()==null && head.getRightNode()==null){
			return 0;
		}

		if(head.getLeftNode()!=null){
			leftcount++;
			findDepth(head.getLeftNode());
		}
		if(head.getRightNode()!=null){
			rightCount++;
			findDepth(head.getRightNode());
		}

		return leftcount>rightCount?leftcount:rightCount;
	}
}
