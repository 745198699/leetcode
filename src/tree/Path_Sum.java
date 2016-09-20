package tree;

import java.util.*;

public class Path_Sum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null)
			return false;
		if(root.left == null && root.right == null && sum - root.val == 0) return true;
		return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
	}

	//    private void dfs(TreeNode node, int cur , List<Integer> list){
	//    	if(node.left==null&&node.right==null){
	//    		list.add(cur+node.val);
	//    		return;
	//    	}
	//    	if(node.left!=null)
	//    		dfs(node.left, cur+node.val,list);
	//    	if(node.right!=null)
	//    		dfs(node.right,cur+node.val,list);
	//    	
	//    }

}
