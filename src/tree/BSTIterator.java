package tree;

import java.util.*;

public class BSTIterator {
	private Stack<Integer> stack = new Stack<>();
	
    public BSTIterator(TreeNode root) {
        init(root);
    }
    private void init(TreeNode root){
    	if(root == null)
    		return;
    	init(root.right);
    	stack.push(root.val);
    	init(root.left);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	return stack.pop();
    }
}
