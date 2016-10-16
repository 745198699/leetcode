package tree;

public class Flatten_Binary_Tree2Linked_List {
	private TreeNode prev = null;

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
		System.out.println(prev.val);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);root.right.right = new TreeNode(7);
		new Flatten_Binary_Tree2Linked_List().flatten(root);
	}
}
