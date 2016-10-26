/**
 * You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */
package tree;
import java.util.*;

public class Path_Sum_III {
	private int result_count=0;
    public int pathSum(TreeNode root, int sum) {
//        int result_count = 0;
        if(root==null)
        	return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	TreeNode cur = queue.poll();
        	dfs(cur,sum,0);
        	
        	if(cur.left!=null)
        		queue.offer(cur.left);
        	
        	if(cur.right!=null)
        		queue.offer(cur.right);
        }
        
        return result_count;
    }
    
    public void dfs(TreeNode root,int sum,int pre_sum){
    	if(root == null)
    		return ;
    	int cur_sum =pre_sum + root.val;
    	if(cur_sum==sum){
    		result_count++;
    	}
    	dfs(root.left,sum,cur_sum);
    	dfs(root.right,sum,cur_sum);
    }
}
