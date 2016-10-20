package tree;
/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * @author yujianbo
 */
public class Kth_Smallest_Element_BST {
    public int kthSmallest(TreeNode root, int k) {
        int count = countRoot(root.left);
        if(count==k-1)
        	return root.val;
        else if(count>k-1)
        	return kthSmallest(root.left, k);
        else
        	return kthSmallest(root.right, k-count-1);
    }
    
    public int countRoot(TreeNode root){
    	if(root == null)
    		return 0;
    	return 1+countRoot(root.left)+countRoot(root.right);
    }
}
