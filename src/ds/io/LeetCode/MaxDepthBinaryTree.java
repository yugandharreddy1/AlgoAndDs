package ds.io.LeetCode;

public class MaxDepthBinaryTree {
	int max=0;
	public static void main(String[] args) {
		TreeNode t=new TreeNode();
		maxDepth(t);
	}


	public static int maxDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		return 1+Math.max(maxDepth(root.left),maxDepth(root.right));

	}
}
