package ds.io.BinaryHeap;

public class FindMaxInMinHeap {

	
	public static void main(String[] args) {
		MinHeap<Integer> n=new MinHeap(Integer.class);
		n.insert(15);
		n.insert(2);
		n.insert(8);
		n.insert(6);
		n.insert(10);
		n.insert(13);
		n.insert(17);
		n.insert(20);
		n.insert(27);
		n.insert(14);
		System.out.println(n);
		System.out.println(findMax(n));
	}

	private static int findMax(MinHeap<Integer> n) {
		
		//get last index as it will be last leaf
		int lastIndex=n.getCount()-1;
		
		//get last parent based on lastIndex so that we can get all the leaf's from last paren to last index
		int lastParentIndex=n.getParentIndex(lastIndex);
		
		
		//first child index will be parent index +1
		int firstChildIndex=lastParentIndex+1;
		
		
		//initalized max ele with first child ele
		int maxElement=n.getElementAtIndex(firstChildIndex);
		
		
		//loop from lastparent to last leaf to get the max of all leafs
		for(int i=firstChildIndex;i<=lastIndex;i++){
			if(maxElement<n.array[i]){
				maxElement=n.array[i];
			}
		}
		return maxElement;
	}
}
