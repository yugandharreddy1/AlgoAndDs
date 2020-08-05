package ds.io.LeetCode;

public class HasPathSum {
	public static void main(String[] args) {
		TreeNode root=new TreeNode();
		hasPathSum(root,22);
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.left == null && root.right == null) return root.val == sum;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
