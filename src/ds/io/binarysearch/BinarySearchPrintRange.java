package ds.io.binarysearch;



//Print all the nodes with in a given range of binary search tree
public class BinarySearchPrintRange {

	public static void main(String[] args) {
		BinarySearchTree bts=new BinarySearchTree();
		Node<Integer> head=new Node(16);
		bts.insert(head, new Node<Integer>(25));
		bts.insert(head, new Node<Integer>(9));
		bts.insert(head, new Node<Integer>(12));
		bts.insert(head, new Node<Integer>(19));
		bts.insert(head, new Node<Integer>(11));

		printRange(head,9,19);
	}

	private static void printRange(Node<Integer> head, int low, int high) {
		
		if(head==null){
			return;
		}
		
		if(low<=head.getData()){
			printRange(head.getLeftNode(),low,high);
		}
		if(low<=head.getData() && head.getData()<=high){
			System.out.println(head.getData());
		}
		if(high>head.getData()){
			printRange(head.getRightNode(), low, high);
		}
	}
}
