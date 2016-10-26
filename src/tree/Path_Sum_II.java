/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
package tree;
import java.util.*;


public class Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> results = new ArrayList<>();
    	if(root == null)
    		return results;
    	
    	backtrack(root, sum, results, new ArrayList<Integer>(),0);
    	
        return results;
    }
    
    public void backtrack(TreeNode root, int sum, List<List<Integer>> results, List<Integer> cur,int cur_sum){
    	cur.add(root.val);
    	if(root.left==null&&root.right==null&&(cur_sum+root.val)==sum){
    		results.add(new ArrayList<>(cur));
    		return;
    	}
    	
    	
    	if(root.left!=null){
    		backtrack(root.left, sum, results, cur, cur_sum+root.val);
    	}
    	
    	if(root.right!=null){
    		backtrack(root.right, sum, results, cur, cur_sum+root.val);
    	}
    	
    	cur.remove(cur.size()-1);
    }
}
