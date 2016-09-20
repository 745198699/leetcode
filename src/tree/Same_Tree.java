package tree;

public class Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        	return true;
        if(q!=null&&p!=null&&q.val==p.val){
        	return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
        }
    	
    	return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
