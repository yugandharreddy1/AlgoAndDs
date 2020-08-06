package ds.io.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTreeExample {
	public static void main(String[] args) {
		TreeNode root=new TreeNode();
		levelOrderTreeExample(root);
	}

	private static List<List<Integer>> levelOrderTreeExample(TreeNode root) {
		List<List<Integer>> List=new ArrayList<>();
		if (root == null) return List;  
		Queue<TreeNode> queue = new LinkedList<>();  
		queue.add(root);  
		while (!queue.isEmpty()) {  
			List<Integer> level = new ArrayList<>();  
			int cnt = queue.size();  
			for (int i = 0; i < cnt; i++) {  
				TreeNode node = queue.poll();  
				level.add(node.val);  
				if (node.left != null) {  
					queue.add(node.left);  
				}
				if (node.right != null) {  
					queue.add(node.right);  
				}  
			}  
			List.add(level);   
		}  

		return List;

	}
}
