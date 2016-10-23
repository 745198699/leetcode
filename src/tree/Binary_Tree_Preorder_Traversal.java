package tree;
import java.util.*;

public class Binary_Tree_Preorder_Traversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		getRes(res, root);
		return res;
	}

	private void getRes(List<Integer>res, TreeNode root){
		if(root==null)
			return ;
		res.add(root.val);
		getRes(res, root.left);
		getRes(res, root.right);
	}

	public List<Integer> preorderTraversal_iterator(TreeNode node) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> rights = new Stack<TreeNode>();
		while(node != null) {
			list.add(node.val);
			if (node.right != null) {
				rights.push(node.right);
			}
			node = node.left;
			if (node == null && !rights.isEmpty()) {
				node = rights.pop();
			}
		}
		return list;}
}
