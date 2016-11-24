package tree;

public class Binary_Tree_Maximum_Path_Sum {
	int max_path = Integer.MIN_VALUE;
	
    public int maxPathSum(TreeNode root) {
        if(root == null)
        	return 0;
        
        maxFromButtonToNode(root);
    	
    	return max_path;
    }
    
    public int maxFromButtonToNode(TreeNode node){
    	if(node == null)
    		return 0;
    	
    	int left = maxFromButtonToNode(node.left);
    	int right = maxFromButtonToNode(node.right);
    	left = (left>0)?left:0;
    	right = (right>0)?right:0;
    	max_path = Math.max(max_path, node.val + left + right);
    	return node.val + Math.max(left, right);
    }
}
