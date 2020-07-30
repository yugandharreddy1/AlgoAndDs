package ds.io.LeetCode;

public class MergeTree {
	public static void main(String[] args) {
		TreeNode t1=new TreeNode();
		TreeNode t2=new TreeNode();
		mergeTree(t1,t2);
	}

	private static  TreeNode mergeTree(TreeNode t1, TreeNode t2) {
		if(t1==null) return t2;
		if(t2==null) return t1;
		TreeNode result=new TreeNode(t1.val+t2.val);
		result.left=mergeTree(t1.left, t2.left);
		result.right=mergeTree(t1.right, t2.right);
		return result;
	}
}
