package tree;
/**
 * 判断tree是否是查询二叉树
 * @author yujianbo
 *
 */
public class Validate_Binary_Search_Tree {
	public boolean isValidBST(TreeNode root) {
		return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	private boolean isValid(TreeNode root, long min, long max){
		if(root==null)
			return true;
		
		if(root.val<=min || root.val>=max)
			return false;
		return isValid(root.right, root.val, max) && isValid(root.left, min, root.val); 
	}
}
