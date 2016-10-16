package tree;

public class Balanced_Binary_Tree {

	public boolean isBalanced_better(TreeNode root) {
		if(root==null){
			return true;
		}
		return getDepth_better(root)==-1;
	}
	public int getDepth_better(TreeNode node){
		int ld = getDepth_better(node.left);
		if(ld==-1)return -1;
		int rd = getDepth_better(node.right);
		if(rd==-1)return -1;
		if(Math.abs(ld-rd)>1)
			return -1;
		return 1+Math.max(ld,rd);
	}
    public boolean isBalanced(TreeNode root) {
    	if(root==null)
    		return true;
        int leftD = getDepth(root.left);
        int righD = getDepth(root.right);
        int diffe = Math.abs(leftD-righD);
        return diffe<2&&isBalanced(root.left)&&isBalanced(root.right);
    }
    
    private int getDepth(TreeNode node){
    	if(node==null)
    		return 0;
    	return 1+Math.max(getDepth(node.left), getDepth(node.right));
    }
    
    
}
