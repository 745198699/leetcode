package tree;

public class Delete_Node_in_a_BST {
	public TreeNode deleteNode_own(TreeNode root, int key) {
		//find the node
		TreeNode del = root;
		TreeNode del_pre = root;
		boolean direction = true;
		while(del != null){
			if(del.val==key)
				break;
			del_pre = del;
			if(key < del.val){
				del = del.left;
				direction = false;
			}
			else{
				del = del.right;
				direction = true;
			}
		}

		//did not found 
		if(del == null)
			return root;
		
		
		//del note has no right
		if(del.right==null){
			if(del==root)
				return root.left;
			if(direction)
				del_pre.right = del.left;
			else
				del_pre.left = del.left;
			return root;
		}

		//find the min one from right child tree
		TreeNode tmp = del.right;
		TreeNode pre = del;
		while(tmp.left != null){
			pre = tmp;
			tmp = tmp.left;
		}

		//remove the delete node replaced by tmp
		del.val = tmp.val;
		if(pre == del){
			del.right = tmp.right;
		}else{
			pre.left=tmp.right;
		}

		return root;
	}
	public TreeNode deleteNode(TreeNode root, int key) {
	    if(root == null){
	        return null;
	    }
	    if(key < root.val){
	        root.left = deleteNode(root.left, key);
	    }else if(key > root.val){
	        root.right = deleteNode(root.right, key);
	    }else{
	        if(root.left == null){
	            return root.right;
	        }else if(root.right == null){
	            return root.left;
	        }
	        
	        TreeNode minNode = findMin(root.right);
	        root.val = minNode.val;
	        root.right = deleteNode(root.right, root.val);
	    }
	    return root;
	}

	private TreeNode findMin(TreeNode node){
	    while(node.left != null){
	        node = node.left;
	    }
	    return node;
	}
}
