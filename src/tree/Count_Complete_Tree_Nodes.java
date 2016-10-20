package tree;

public class Count_Complete_Tree_Nodes {

	public int countNodes(TreeNode root) {
		int right = getRightLen(root);
		int left = getLeftLen(root);
		if(right == left)
			return (1<<left)-1;
		else
			return 1+countNodes(root.left)+countNodes(root.right);
	}

	private int getLeftLen(TreeNode node){
		int count = 0;
		while(node != null){
			count++;
			node = node.left;
		}
		return count;
	}
	private int getRightLen(TreeNode node){
		int count = 0;
		while(node != null){
			count++;
			node = node.right;
		}
		return count;
	}

}