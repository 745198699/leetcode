package tree;
import java.util.*;
/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * @author yujianbo
 */
public class Sum_Root_to_Leaf_Numbers {
	int re = 0;
    public int sumNumbers(TreeNode root) {
    	if(root==null)
    		return 0;
        backtrack(root, 0);
        return re;
    }
    
    private void backtrack(TreeNode root, int curValue){
    	curValue = curValue*10+root.val;

    	if(root.right==null&&root.left==null){
    		re+=curValue;
    		return;
    	}
    	
    	if(root.left!=null)
    		backtrack(root.left, curValue);
    	if(root.right!=null)
    		backtrack(root.right, curValue);
    }
    

    public int sumNumbers_better(TreeNode root) {
    	return sum(root,0);
    }
    
    public int sum(TreeNode root, int curSum){
    	if (root == null) return 0;
    	if (root.right == null && root.left == null) return curSum*10 + root.val;
    	return sum(root.left, curSum*10 + root.val) + sum(root.right, curSum*10 + root.val);
    }
}
