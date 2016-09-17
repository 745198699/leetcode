package tree;

public class Lowest_Common_Ancestor_of_BST {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val>q.val)
			return lowestCommonAncestor(root, q, p);
		else{
			if(p.val<=root.val&&q.val>=root.val){
				return root;
			}
			if(q.val<root.val)
				return lowestCommonAncestor(root.left, p, q);
			else
				return lowestCommonAncestor(root.right, p, q);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		//		root.right = new TreeNode(8);
		//		root.left.left = new TreeNode(0);root.left.right = new TreeNode(4);
		//		root.right.left = new TreeNode(7);root.right.right = new TreeNode(9);
		TreeNode  re = new Lowest_Common_Ancestor_of_BST().lowestCommonAncestor(root, new TreeNode(6), new TreeNode(2));
		System.out.println(re.val);
	}

}
