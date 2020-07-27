package ds.io.LeetCode;

public class SearchBST {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7));
		TreeNode res= searchBST(root,2);
		System.err.println(res.left.val);
	}

	public static TreeNode searchBST(TreeNode root, int val) {
		if(root.val==val){
			return root;
		}
		if(val<root.val && root.left!=null){
			root=searchBST(root.left,val);
		}
		else if(val>root.val&& root.right!=null){
			root=searchBST(root.right,val);
		}

		return root;
	}
}
