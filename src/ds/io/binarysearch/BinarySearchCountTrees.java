package ds.io.binarysearch;


//Find number of different possible tree structures that can be formed by given number
public class BinarySearchCountTrees {
	public static void main(String[] args) {
		
		countTree(5);
	}

	private static int countTree(int num) {
		// when number of nodes is one the return 1 possible tree
		if(num<=1){
			return 1;
		}
		
		int sum=0;
		
		for(int i=0;i<=num;i++){  // considering every node can be root the nodes before it will be left and the nodes after it will be right
			int leftCount=countTree(i-1);
			int rightCount=countTree(num-i);//nodes to the left and right form where own sub trees
			
			sum=sum+(leftCount*rightCount);   // the possible combination of both left and right sub trees
		}
		
		return sum;
	}

}
