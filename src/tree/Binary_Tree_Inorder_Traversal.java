package tree;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
		getRes(res, root);
		return res;
    }

	private void getRes(List<Integer>res, TreeNode root){
		if(root==null)
			return ;
		getRes(res, root.left);
		res.add(root.val);
		getRes(res, root.right);
	}
}
